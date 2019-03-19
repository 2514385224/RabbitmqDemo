package 复习;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class Recver {
	
	private final static String QUERE="testhello";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Connection connection=getConnectionUtil.getConnection();
		
		Channel channel=connection.createChannel();
		
		channel.queueDeclare(QUERE, false, false, false, null);
		
		//定义一个消费者
		Consumer consumer=new DefaultConsumer(channel) {
			 public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
	                    byte[] body) throws IOException {
	                String message = new String(body, "UTF-8");
	                System.out.println(" [x] Received '" + message + "'");
	            }
			
		};
	
		
		//接收消息
		channel.basicConsume(QUERE, true,consumer);
		
			
	}
}
