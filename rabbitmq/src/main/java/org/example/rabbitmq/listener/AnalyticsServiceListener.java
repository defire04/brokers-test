package org.example.rabbitmq.listener;

import org.example.rabbitmq.event.BranchOfficeEvent;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsServiceListener {

    @RabbitListener(queues = "#{analyticsServiceQueue.name}")
    public void handleBranchOfficeEvent(BranchOfficeEvent event) {
        System.out.println("Analytics Service received: " + event);
        // Обработка события
    }

    @Bean
    public Queue analyticsServiceQueue() {
        return new Queue("analytics-service-queue");
    }

    @Bean
    public Binding analyticsServiceBinding(Queue analyticsServiceQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(analyticsServiceQueue)
                .to(topicExchange)
                .with("#.branch_office.#");
    }
}