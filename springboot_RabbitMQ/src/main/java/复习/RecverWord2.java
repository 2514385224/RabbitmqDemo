package ��ϰ;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * ������1
 * @author 2514385224
 *
 */
public class RecverWord2 {

	private final static String QUEUE="testwork";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection=getConnectionUtil.getConnection();
		
	Channel channel=connection.createChannel();
	
	channel.queueDeclare(QUEUE, false, false, false, null);
	
	//ͬһʱ�̷�����ֻ�ᷢ��һ����Ϣ�������ߣ�ֻ�е�ǰ�����߽���Ϣ������Ϻ�Ż��ȡ����һ����Ϣ
	
	channel.basicQos(1);
	
	//����һ��������
	Consumer consumer=new DefaultConsumer(channel) {
		 public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
		                    byte[] body) throws IOException {
       String message = new String(body, "UTF-8");
       System.out.println(" ������ 2[x] Received '" + message + "'");
	       try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    //����2��falseΪȷ���յ���Ϣ��trueΪ�ܽ��յ���Ϣ
       channel.basicAck(envelope.getDeliveryTag(), false);
		
		 }
	};
	
	channel.basicConsume(QUEUE, false,consumer);
	}

}
