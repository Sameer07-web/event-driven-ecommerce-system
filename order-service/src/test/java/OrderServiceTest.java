package com.sameer.order_service.service;

import com.sameer.order_service.dto.CreateOrderRequest;
import com.sameer.order_service.dto.OrderEvent;
import com.sameer.order_service.dto.OrderResponse;
import com.sameer.order_service.dto.UpdateOrderRequest;
import com.sameer.order_service.entity.Order;
import com.sameer.order_service.entity.OrderStatus;
import com.sameer.order_service.kafka.OrderProducer;
import com.sameer.order_service.mapper.OrderMapper;
import com.sameer.order_service.repository.OrderRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private OrderProducer orderProducer;

    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderService orderService;

    @Test
    void createOrder_ShouldSaveOrderAndSendKafkaEvent() {
        CreateOrderRequest request = new CreateOrderRequest();
        request.setProductName("iPhone 16");
        request.setQuantity(2);
        request.setPrice(85000.0);

        Order order = Order.builder()
                .productName("iPhone 16")
                .quantity(2)
                .price(85000.0)
                .status(OrderStatus.CREATED)
                .build();

        OrderResponse response = new OrderResponse();
        response.setProductName("iPhone 16");

        when(orderMapper.toEntity(any(CreateOrderRequest.class))).thenReturn(order);
        when(orderRepository.save(any(Order.class))).thenReturn(order);
        when(orderMapper.toResponse(any(Order.class))).thenReturn(response);

        OrderResponse savedOrder = orderService.createOrder(request);

        assertNotNull(savedOrder);
        assertEquals("iPhone 16", savedOrder.getProductName());

        verify(orderRepository, times(1)).save(any(Order.class));
        verify(orderProducer, times(1)).sendOrderEvent(any(OrderEvent.class));
    }

    @Test
    void getOrderById_ShouldReturnOrderResponse() {
        Order order = Order.builder()
                .id(1L)
                .productName("Laptop")
                .quantity(1)
                .price(50000.0)
                .status(OrderStatus.CREATED)
                .build();

        OrderResponse response = new OrderResponse();
        response.setProductName("Laptop");

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));
        when(orderMapper.toResponse(any(Order.class))).thenReturn(response);

        OrderResponse result = orderService.getOrderById(1L);

        assertNotNull(result);
        assertEquals("Laptop", result.getProductName());
    }

    @Test
    void deleteOrder_ShouldDeleteOrderAndSendKafkaEvent() {
        Order order = Order.builder()
                .id(1L)
                .productName("Phone")
                .quantity(1)
                .price(20000.0)
                .status(OrderStatus.CREATED)
                .build();

        when(orderRepository.findById(1L)).thenReturn(Optional.of(order));

        orderService.deleteOrder(1L);

        verify(orderRepository, times(1)).delete(order);
        verify(orderProducer, times(1)).sendOrderEvent(any(OrderEvent.class));
    }
}