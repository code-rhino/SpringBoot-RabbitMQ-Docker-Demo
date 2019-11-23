package com.codedifferently.demos.rabbitmq.services;

import com.codedifferently.demos.rabbitmq.config.RabbitConfig;
import com.codedifferently.demos.rabbitmq.domain.Order;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderMessageSender {
    private final RabbitTemplate rabbitTemplate;
    private static final Logger logger = LoggerFactory.getLogger(OrderMessageSender.class);

    @Autowired
    public OrderMessageSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(Order order){
        logger.info("order {}", order);
        this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_DEAD_ORDERS, order);
    }
}
