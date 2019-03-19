package com.jju.rabbitmq.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;


/*
 * topic 是RabbitMQ中最灵活的一种方式，可以根据routing_key自由的绑定不同的队列

	首先对topic规则配置，这里使用两个队列来测试
 */
@Configuration
public class TopicRabbitConfig {

   final static String message = "topic.message";
   final static String messages = "topic.messages";

   @Bean
   public Queue queueMessage() {
       return new Queue(TopicRabbitConfig.message,true);
   }

   @Bean
   public Queue queueMessages() {
       return new Queue(TopicRabbitConfig.messages,true);
   }

   @Bean
   TopicExchange exchange() {
       return new TopicExchange("exchange");
   }

   @Bean
   Binding bindingExchangeMessage(Queue queueMessage, TopicExchange exchange) {
       return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
   }

   @Bean
   Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
       return BindingBuilder.bind(queueMessages).to(exchange).with("topic.messages");
   }
   
}

