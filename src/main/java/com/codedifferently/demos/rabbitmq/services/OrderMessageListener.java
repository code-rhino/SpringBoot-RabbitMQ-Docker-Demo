package com.codedifferently.demos.rabbitmq.services;

import com.codedifferently.demos.rabbitmq.config.RabbitConfig;
import com.codedifferently.demos.rabbitmq.domain.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderMessageListener {

    private static final Logger logger = LoggerFactory.getLogger(OrderMessageListener.class);

    @RabbitListener(queues = RabbitConfig.QUEUE_ORDERS)
    public void processOrder(Order order){
        logger.info("Order received: {}", order);
    }
}
