package com.angel.amqpproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private final RabbitProducerService rabbitProducerService;

    @Autowired
    public MyController(RabbitProducerService rabbitProducerService) {
        this.rabbitProducerService = rabbitProducerService;
    }

    @PostMapping
    public void postMessage(@RequestBody TweetMessage tweetMessage) {
        this.rabbitProducerService.send(tweetMessage);
    }
}
