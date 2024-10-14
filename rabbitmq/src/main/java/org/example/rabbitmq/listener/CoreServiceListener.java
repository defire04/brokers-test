package org.example.testrabbitmq.service2;
import org.example.testrabbitmq.connection.BranchOfficeEvent;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
@Component
public class CoreServiceListener {

    @RabbitListener(queues = "#{coreServiceQueue.name}")
    public void handleBranchOfficeEvent(BranchOfficeEvent event) {
        System.out.println("Core Service received: " + event);
        // Обработка события
    }

    @Bean
    public Queue coreServiceQueue() {
        return new Queue("core-service-queue");
    }

    @Bean
    public Binding coreServiceBinding(Queue coreServiceQueue, TopicExchange topicExchange) {
        return BindingBuilder.bind(coreServiceQueue)
                .to(topicExchange)
                .with("core.branch_office.#");
    }
}