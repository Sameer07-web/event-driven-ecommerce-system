package com.sameer.order_service.event.publisher;

import com.sameer.order_service.config.KafkaTopicProperties;
import com.sameer.order_service.event.model.OrderCancelledEvent;
import com.sameer.order_service.event.model.OrderCreatedEvent;
import com.sameer.order_service.event.model.OrderUpdatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class OrderEventPublisherImpl implements OrderEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaTopicProperties topicProperties;

    public OrderEventPublisherImpl(KafkaTemplate<String, Object> kafkaTemplate,
                                   KafkaTopicProperties topicProperties) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicProperties = topicProperties;
    }

    @Override
    public void publishOrderCreatedEvent(OrderCreatedEvent event) {
        kafkaTemplate.send(topicProperties.getOrderCreated(), event.getOrderId().toString(), event);
    }

    @Override
    public void publishOrderUpdatedEvent(OrderUpdatedEvent event) {
        kafkaTemplate.send(topicProperties.getOrderUpdated(), event.getOrderId().toString(), event);
    }

    @Override
    public void publishOrderCancelledEvent(OrderCancelledEvent event) {
        kafkaTemplate.send(topicProperties.getOrderCancelled(), event.getOrderId().toString(), event);
    }
}
