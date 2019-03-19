package 复习;

import java.io.IOException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/**
 * 消费者1
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
	
	//同一时刻服务器只会发送一条消息给消费者，只有当前消费者将消息处理完毕后才会获取到下一条消息
	
	channel.basicQos(1);
	
	//定义一个消费者
	Consumer consumer=new DefaultConsumer(channel) {
		 public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
		                    byte[] body) throws IOException {
       String message = new String(body, "UTF-8");
       System.out.println(" 消费者 2[x] Received '" + message + "'");
	       try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    //参数2：false为确定收到消息，true为拒接收到消息
       channel.basicAck(envelope.getDeliveryTag(), false);
		
		 }
	};
	
	channel.basicConsume(QUEUE, false,consumer);
	}

}
