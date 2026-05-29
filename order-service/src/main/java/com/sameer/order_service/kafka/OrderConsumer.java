package com.sameer.order_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @KafkaListener(
            topics = "order-topic",
            groupId = "order-group"
    )
    public void consume(String message) {

        System.out.println(
                "Received Order Event: " + message
        );
    }
}