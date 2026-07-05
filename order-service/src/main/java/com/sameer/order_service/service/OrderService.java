package com.sameer.order_service.service;

import com.sameer.order_service.dto.CreateOrderRequest;
import com.sameer.order_service.dto.OrderResponse;
import com.sameer.order_service.dto.UpdateOrderRequest;

public interface OrderService {

    OrderResponse createOrder(CreateOrderRequest request);

    OrderResponse getOrderById(Long id);

    OrderResponse updateOrder(Long id, UpdateOrderRequest request);

    void deleteOrder(Long id);
}
