package com.sameer.order_service.kafka;

import com.sameer.order_service.dto.OrderEvent;
import com.sameer.order_service.entity.AuditEvent;
import com.sameer.order_service.repository.AuditEventRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;

import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class OrderConsumer {

    private static final Logger log =
            LoggerFactory.getLogger(OrderConsumer.class);

    private final AuditEventRepository auditEventRepository;

    public OrderConsumer(
            AuditEventRepository auditEventRepository) {

        this.auditEventRepository = auditEventRepository;
    }

    @RetryableTopic(
            attempts = "3",
            backoff = @Backoff(delay = 2000),
            dltTopicSuffix = "-dlt"
    )
    @KafkaListener(
            topics = "order-topic",
            groupId = "order-group"
    )
    public void consume(OrderEvent event) {

        log.info(
                "Received Order Event -> ID: {}, Product: {}, Status: {}",
                event.getOrderId(),
                event.getProductName(),
                event.getStatus()
        );

        // Simulate Failure
        if ("FAIL".equalsIgnoreCase(event.getProductName())) {

            throw new RuntimeException(
                    "Simulated Kafka Consumer Failure");
        }

        AuditEvent auditEvent =
                AuditEvent.builder()
                        .orderId(event.getOrderId())
                        .productName(event.getProductName())
                        .status(event.getStatus())
                        .eventTime(LocalDateTime.now())
                        .build();

        auditEventRepository.save(auditEvent);

        log.info(
                "Audit Event Saved Successfully -> Order ID: {}",
                event.getOrderId()
        );
    }

    @DltHandler
    public void handleDlt(OrderEvent event) {

        log.error(
                "DLQ Event Received -> Order ID: {}, Product: {}",
                event.getOrderId(),
                event.getProductName()
        );
    }
}