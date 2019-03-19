package 复习;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class RecverLuYou1 {

	private final static String EXCHANGE_NAME="testroute";
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection=getConnectionUtil.getConnection();
		
		Channel channel=connection.createChannel();
		
		String queueName = channel.queueDeclare().getQueue();
		 channel.exchangeDeclare(EXCHANGE_NAME, "direct");
		
		//绑定队列到交换机
		
		channel.queueBind(queueName, EXCHANGE_NAME, "info.gogo");
		
		channel.basicQos(1);
		//定义一个消费者
				Consumer consumer=new DefaultConsumer(channel) {
					 public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					                    byte[] body) throws IOException {
			       String message = new String(body, "UTF-8");
			       System.out.println(" 消费者 1[x] Received '" + message + "'");
				      
			       
				    //参数2：false为确定收到消息，true为拒接收到消息
			       channel.basicAck(envelope.getDeliveryTag(), false);
				
			       
					 }
				};
				channel.basicConsume(queueName, false,consumer);
		
		
		
	}

}
