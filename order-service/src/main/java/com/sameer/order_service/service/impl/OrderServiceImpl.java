package com.sameer.order_service.service.impl;

import com.sameer.order_service.dto.CreateOrderRequest;
import com.sameer.order_service.dto.OrderEvent;
import com.sameer.order_service.dto.OrderResponse;
import com.sameer.order_service.dto.UpdateOrderRequest;
import com.sameer.order_service.entity.Order;
import com.sameer.order_service.entity.OrderStatus;
import com.sameer.order_service.exception.OrderNotFoundException;
import com.sameer.order_service.kafka.OrderProducer;
import com.sameer.order_service.mapper.OrderMapper;
import com.sameer.order_service.repository.OrderRepository;
import com.sameer.order_service.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderProducer orderProducer,
                            OrderMapper orderMapper) {

        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
        this.orderMapper = orderMapper;
    }

    public OrderResponse createOrder(CreateOrderRequest request) {

        Order order = orderMapper.toEntity(request);
        order.setStatus(OrderStatus.CREATED);

        Order savedOrder = orderRepository.save(order);

        OrderEvent event = new OrderEvent(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getPrice(),
                savedOrder.getStatus().name()
        );

        orderProducer.sendOrderEvent(event);

        return orderMapper.toResponse(savedOrder);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {
        Order order = getOrderEntityById(id);
        return orderMapper.toResponse(order);
    }

    public OrderResponse updateOrder(Long id, UpdateOrderRequest request) {

        Order existingOrder = getOrderEntityById(id);

        orderMapper.updateEntityFromRequest(request, existingOrder);

        if (request.getStatus() != null) {
            existingOrder.setStatus(OrderStatus.valueOf(request.getStatus()));
        }

        Order savedOrder = orderRepository.save(existingOrder);

        OrderEvent event = new OrderEvent(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getPrice(),
                savedOrder.getStatus().name()
        );

        orderProducer.sendOrderEvent(event);

        return orderMapper.toResponse(savedOrder);
    }

    public void deleteOrder(Long id) {

        Order order = getOrderEntityById(id);

        orderRepository.delete(order);

        OrderEvent event = new OrderEvent(
                order.getId(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice(),
                "DELETED"
        );

        orderProducer.sendOrderEvent(event);
    }

    private Order getOrderEntityById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found with ID: " + id));
    }
}