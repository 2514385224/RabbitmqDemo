package com.jju.rabbitmq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jju.rabbitmq.hello.Send1;
import com.jju.rabbitmq.model.User;

@RestController
public class RabbiMQTest {

	@Autowired
	private Send1 send1;
	
	
	
	@RequestMapping("/hello")
	public void hello()
	{
//		User user=new User();
//		user.setAge(1);
//		user.setId(1);
//		user.setName("zhou");
//		send1.send(user);
		
		//send1.send();
		send1.send1("1");
		send1.send2("2");
		
	}
}
