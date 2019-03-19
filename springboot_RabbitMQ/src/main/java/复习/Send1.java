package 复习;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * 简单模式,生产者发送消息，消费者从队列中去消息
 * 一条消息对应一个消防者
 * 
 * @author 2514385224
 *
 */
public class Send1 {

	private final static String QUEUE_NAME="testhello";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection=getConnectionUtil.getConnection();
		
		//从连接中创建通道
		
		Channel channel=connection.createChannel();
		
		//申明队列，如果不存在就创建，
		/**
		 * 参数1:队列名
		 * 参数2: durable:是否持久化，队列的申明是存放到内存中，如果rabbimq重启，
		 * 会丢失，如果想重启后还存在就使队列持久化，保存到Erlang自带的Mnesia数据库中，当Rabbitmq重启后对读取改数据库
		 * 
		 * 
		 * 
		 */
		channel.queueDeclareNoWait(QUEUE_NAME, false, false, false, null);
		
		String message="Hello World!";
		
		//参数1:交换机，此处没有，参数2：发送到那个队列，参数3：属性   参数4:内容
		
		channel.basicPublish("", QUEUE_NAME,null, message.getBytes());
		
		System.out.println("发送数据：："+message+"'");
		
		//关闭通道，和连接
		
		channel.close();
		connection.close();
		
		
		
		
		
	}

}
