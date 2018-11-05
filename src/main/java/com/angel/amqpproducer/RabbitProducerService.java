package com.angel.amqpproducer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitProducerService {

    private final MyProperties myProperties;

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public RabbitProducerService(MyProperties myProperties, RabbitTemplate rabbitTemplate) {
        this.myProperties = myProperties;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send (TweetMessage tweetMessage) {
        this.rabbitTemplate.convertAndSend(myProperties.getTwitterExchange(), myProperties.getRoutingKey(), tweetMessage);
    }
}
