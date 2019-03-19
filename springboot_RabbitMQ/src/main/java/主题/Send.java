package ����;
//������

import java.util.UUID;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send{
	private  static  final String EXCHANGE_NAME = "topic_logs";
	//����󶨼�     
    private static String[] routing_keys = new String[] { "kernal.info", "cron.warning",    
            "auth.info", "kernel.critical" };   
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    try(Connection connection = factory.newConnection();
	         Channel channel = connection.createChannel()){
	        channel.exchangeDeclare(EXCHANGE_NAME,"topic");
//
//	        String message = args.length < 1?"��Ϣ:Hello World!":
//	                            String.join("",args);

	        for (String routing_key : routing_keys)    
	        {  
	          String message = UUID.randomUUID().toString();    
		      channel.basicPublish(EXCHANGE_NAME,routing_key,null,(message).getBytes("UTF-8"));
		      System.out.println("[x] ����Sent'" +routing_key+"-----"+ message + "'");
	        }
	    }
	}
}