package 路由;

import java.io.IOException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ReceiveLogs {
	
	private static final String EXCHANGE_NAME = "ex_logs_direct";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.exchangeDeclare(EXCHANGE_NAME, "direct");
	    String queueName = channel.queueDeclare().getQueue();
	    channel.queueBind(queueName, EXCHANGE_NAME, "info");

	    System.out.println("[*]等待消息。退出按CTRL + C");

	    DeliverCallback deliverCallback =(consumerTag,delivery)->{
	    String message = new String(delivery.getBody(),"UTF-8");
	        System.out.println("[x] Received'" + message + "'");
	    };
	    channel.basicConsume(queueName,true,deliverCallback,consumerTag  -> {});
	}

}
