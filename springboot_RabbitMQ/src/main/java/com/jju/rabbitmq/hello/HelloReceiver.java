package com.jju.rabbitmq.hello;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.jju.rabbitmq.model.User;

@Component
@RabbitListener(queues = "hello")
public class HelloReceiver {
 
    @RabbitHandler
    public void process(User hello) {
        System.out.println("HelloReceiver1  : " + hello);
    }
}
