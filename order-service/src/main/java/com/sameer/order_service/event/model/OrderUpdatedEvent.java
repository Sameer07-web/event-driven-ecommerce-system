package com.sameer.order_service.event.model;

import com.sameer.common.event.BaseEvent;
import lombok.Getter;

@Getter
public class OrderUpdatedEvent extends BaseEvent {
    private final Long orderId;
    private final String productName;
    private final Integer quantity;
    private final Double price;
    private final String orderStatus;

    public OrderUpdatedEvent(Long orderId, String productName, Integer quantity, Double price, String orderStatus) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.orderStatus = orderStatus;
    }
}
