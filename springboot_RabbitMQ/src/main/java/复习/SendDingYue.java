package ��ϰ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class SendDingYue {

	private final static String EXCHANGE_NAME="testexchange";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	Connection connection =getConnectionUtil.getConnection();
	
	Channel channel=connection.createChannel();
	
	//����exchange
	channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
	
	
	for(int i=0;i<=100;i++)
	{
		String message="hello World"+i;
	channel.basicPublish(EXCHANGE_NAME, "", null, (message+1).getBytes());
	System.out.println("������Ϣ:"+message+"--"+i);
	}
	
	channel.close();
	connection.close();

	}

}
