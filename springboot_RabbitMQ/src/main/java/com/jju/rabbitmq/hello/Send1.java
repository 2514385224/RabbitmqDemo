package com.jju.rabbitmq.hello;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jju.rabbitmq.model.User;

@Component
public class Send1 {
	 @Autowired
	 private AmqpTemplate rabbitTemplate;
	 
	 public void send(User user) {
	      //  String context = "hello ";	        
	        this.rabbitTemplate.convertAndSend("hello", user);
	        System.out.println("Sender : " + user);
	        
	 }
	 
	 
	 public void send1(String message) {
	     String context = "topic hi, i am message 1";
	     System.out.println("Sender : " + context);
	     this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
	 }
	  
	 public void send2(String message) {
	     String context = "topic hi, i am messages 2";
	     System.out.println("Sender : " + context);
	     this.rabbitTemplate.convertAndSend("exchange", "topic.message", context);
	 }
	 
//	 public void send3() {
//	     String context = "topic hi, i am messages 3";
//	     System.out.println("Sender : " + context);
//	     this.rabbitTemplate.convertAndSend("exchange", "topic.*", context);
//	 }
	 
	 
	 
	 public void send() {
	        String context = "hi, fanout msg ";
	        System.out.println("Sender : " + context);
	        this.rabbitTemplate.convertAndSend("fanoutExchange","", context);
	        
	 }



}
