package 发布订阅;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
/**
 * s
 * @author 2514385224
 *
 */
public class EmitLog {
	
	//队列名
	private  static  final String EXCHANGE_NAME = "logs";
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    try(Connection connection = factory.newConnection();
	         Channel channel = connection.createChannel()){
	        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");

	        String message = args.length < 1?"信息:Hello World!":
	                            String.join("",args);

	       for(int i=0;i<=20;i++)
	       {
	      channel.basicPublish(EXCHANGE_NAME,"",null,(message+i).getBytes("UTF-8"));
	      System.out.println("[x] 发送Sent'" + message + "'"+i);
	       }
	}

	}
}
