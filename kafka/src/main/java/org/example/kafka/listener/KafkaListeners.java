package org.example.testkkafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "my-topic", groupId = "service1")
    public void listenService1(String message) {
        System.out.println("Received message in Service 1: " + message);
    }

    @KafkaListener(topics = "my-topic", groupId = "service2")
    public void listenService2(String message) {
        System.out.println("Received message in Service 2: " + message);
    }

    @KafkaListener(topics = "my-topic", groupId = "service3")
    public void listenService3(String message) {
        System.out.println("Received message in Service 3: " + message);
    }
}
