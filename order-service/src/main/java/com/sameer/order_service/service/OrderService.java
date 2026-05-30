package com.sameer.order_service.service;

import com.sameer.order_service.dto.OrderEvent;
import com.sameer.order_service.entity.Order;
import com.sameer.order_service.entity.OrderStatus;
import com.sameer.order_service.exception.OrderNotFoundException;
import com.sameer.order_service.kafka.OrderProducer;
import com.sameer.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    public OrderService(OrderRepository orderRepository,
                        OrderProducer orderProducer) {

        this.orderRepository = orderRepository;
        this.orderProducer = orderProducer;
    }

    // CREATE ORDER
    public Order createOrder(Order order) {

        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        OrderEvent event = new OrderEvent(
                savedOrder.getId(),
                savedOrder.getProductName(),
                savedOrder.getQuantity(),
                savedOrder.getPrice(),
                savedOrder.getStatus().name()
        );

        orderProducer.sendOrderEvent(event);

        return savedOrder;
    }

    // GET ORDER
    public Order getOrderById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new OrderNotFoundException(
                                "Order not found with ID: " + id));
    }

    // UPDATE ORDER
    public Order updateOrder(Long id, Order updatedOrder) {

        Order existingOrder = getOrderById(id);

        existingOrder.setProductName(updatedOrder.getProductName());
        existingOrder.setQuantity(updatedOrder.getQuantity());
        existingOrder.setPrice(updatedOrder.getPrice());

        if (updatedOrder.getStatus() != null) {
            existingOrder.setStatus(updatedOrder.getStatus());
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

        return savedOrder;
    }

    // DELETE ORDER
    public void deleteOrder(Long id) {

        Order order = getOrderById(id);

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
}