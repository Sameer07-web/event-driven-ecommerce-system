package com.sameer.order_service.service.impl;

import com.sameer.order_service.dto.CreateOrderRequest;
import com.sameer.order_service.dto.OrderResponse;
import com.sameer.order_service.dto.UpdateOrderRequest;
import com.sameer.order_service.entity.Order;
import com.sameer.order_service.entity.OrderStatus;
import com.sameer.order_service.event.mapper.OrderEventMapper;
import com.sameer.order_service.event.publisher.OrderEventPublisher;
import com.sameer.order_service.exception.OrderNotFoundException;
import com.sameer.order_service.mapper.OrderMapper;
import com.sameer.order_service.repository.OrderRepository;
import com.sameer.order_service.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderEventPublisher orderEventPublisher;
    private final OrderEventMapper orderEventMapper;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderEventPublisher orderEventPublisher,
                            OrderEventMapper orderEventMapper,
                            OrderMapper orderMapper) {

        this.orderRepository = orderRepository;
        this.orderEventPublisher = orderEventPublisher;
        this.orderEventMapper = orderEventMapper;
        this.orderMapper = orderMapper;
    }

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {

        Order order = orderMapper.toEntity(request);
        order.setStatus(OrderStatus.CREATED);

        Order savedOrder = orderRepository.save(order);

        orderEventPublisher.publishOrderCreatedEvent(
                orderEventMapper.toCreatedEvent(savedOrder)
        );

        return orderMapper.toResponse(savedOrder);
    }

    @Override
    @Transactional(readOnly = true)
    public OrderResponse getOrderById(Long id) {
        Order order = getOrderEntityById(id);
        return orderMapper.toResponse(order);
    }

    @Override
    public OrderResponse updateOrder(Long id, UpdateOrderRequest request) {

        Order existingOrder = getOrderEntityById(id);

        orderMapper.updateEntityFromRequest(request, existingOrder);

        if (request.getStatus() != null) {
            existingOrder.setStatus(OrderStatus.valueOf(request.getStatus()));
        }

        Order savedOrder = orderRepository.save(existingOrder);

        orderEventPublisher.publishOrderUpdatedEvent(
                orderEventMapper.toUpdatedEvent(savedOrder)
        );

        return orderMapper.toResponse(savedOrder);
    }

    @Override
    public void deleteOrder(Long id) {

        Order order = getOrderEntityById(id);
        
        order.setStatus(OrderStatus.CANCELLED);
        Order savedOrder = orderRepository.save(order);

        orderEventPublisher.publishOrderCancelledEvent(
                orderEventMapper.toCancelledEvent(savedOrder)
        );
    }

    private Order getOrderEntityById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found with ID: " + id));
    }
}
