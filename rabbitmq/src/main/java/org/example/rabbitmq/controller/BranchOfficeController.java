package org.example.rabbitmq.controller;

import org.example.rabbitmq.event.BranchOfficeEvent;
import org.example.rabbitmq.publisher.BranchOfficePublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchOfficeController {

    private final BranchOfficePublisher publisher;

    public BranchOfficeController(BranchOfficePublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/publish")
    public String publishEvent(@RequestBody BranchOfficeEvent event) {
        publisher.publishEvent(event);
        return "Event published successfully";
    }
}