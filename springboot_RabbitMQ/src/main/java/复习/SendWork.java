package ∏¥œ∞;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SendWork {

	private final static String QUEUE_NAME="testwork";
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection=getConnectionUtil.getConnection();
	
		Channel channel=connection.createChannel();
	
		//…Í√˜∂”¡–
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		
		for(int i=0;i<=100;i++)
		{
			String message="-"+i;
			channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
			System.out.println(message);
			Thread.sleep(i*10);
		}
		channel.close();
		connection.close();
		
		
		
		
		
	}

}
