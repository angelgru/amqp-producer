package com.angel.amqpproducer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfiguration {

    private final MyProperties myProperties;

    @Autowired
    public RabbitConfiguration(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    //    Creating the queue from which the consumer is going to consume messages in case it isn't created
//    when we submit the message, if it was created Rabbit will ignore this
    @Bean
    public Queue queue() {
        return new Queue(myProperties.getTwitterQueue());
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(myProperties.getTwitterExchange());
    }

    @Bean
    public MessageConverter jsonMessageConvertor() {
        return new Jackson2JsonMessageConverter();
    }
}
