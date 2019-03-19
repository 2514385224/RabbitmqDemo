package ��ϰ;

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
		
		//�󶨶��е�������
		
		channel.queueBind(queueName, EXCHANGE_NAME, "info.gogo");
		
		channel.basicQos(1);
		//����һ��������
				Consumer consumer=new DefaultConsumer(channel) {
					 public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					                    byte[] body) throws IOException {
			       String message = new String(body, "UTF-8");
			       System.out.println(" ������ 1[x] Received '" + message + "'");
				      
			       
				    //����2��falseΪȷ���յ���Ϣ��trueΪ�ܽ��յ���Ϣ
			       channel.basicAck(envelope.getDeliveryTag(), false);
				
			       
					 }
				};
				channel.basicConsume(queueName, false,consumer);
		
		
		
	}

}
