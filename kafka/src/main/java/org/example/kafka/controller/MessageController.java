package org.example.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.example.kafka.publisher.KafkaPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final KafkaPublisher kafkaPublisher;

    @PostMapping("/publish")
    @Async
    public ResponseEntity<String> publishMessage(@RequestBody Map<String, String> message) {
        kafkaPublisher.sendMessage(message.get("message"));
        return ResponseEntity.ok(message.get("message"));
    }
}