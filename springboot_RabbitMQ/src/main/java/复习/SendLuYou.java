package ¸´Ï°;

import java.util.UUID;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SendLuYou {

	private static String[] strings= {"info.gogo","warring.gogo","info.route"};
	private final static String EXCHANGE_NAME="testroute";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection=getConnectionUtil.getConnection();
		
		Channel channel=connection.createChannel();
		
		 channel.exchangeDeclare(EXCHANGE_NAME, "direct");  
		for(String s : strings)
		{
		String message=UUID.randomUUID().toString();
		channel.basicPublish(EXCHANGE_NAME, s, null, message.getBytes());
		System.out.println(s+"--"+message);
		}
		channel.close();
		connection.close();
	}

}
