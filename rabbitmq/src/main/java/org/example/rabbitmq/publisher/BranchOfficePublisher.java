package org.example.testrabbitmq.connection;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BranchOfficePublisher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.routing-key-pattern}")
    private String routingKeyPattern;

    public BranchOfficePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publishEvent(BranchOfficeEvent event) {
        String routingKey = String.format(routingKeyPattern,
                event.getServiceName(),
                event.getEntityName(),
                event.getAction());
        rabbitTemplate.convertAndSend(routingKey, event);
    }
}

