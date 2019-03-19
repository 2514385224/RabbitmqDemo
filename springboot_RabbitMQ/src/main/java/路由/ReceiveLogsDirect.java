package 路由;

import java.util.Random;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


public class ReceiveLogsDirect  
{  
  
    private static final String EXCHANGE_NAME = "ex_logs_direct";  
    private static final String[] SEVERITIES = { "info", "warning", "error" };  
  
    public static void main(String[] argv) throws java.io.IOException,  
            java.lang.InterruptedException, Exception  
    {  
        // 创建连接和频道  
        ConnectionFactory factory = new ConnectionFactory();  
        factory.setHost("localhost");  
        Connection connection = factory.newConnection();  
        Channel channel = connection.createChannel();  
        // 声明direct类型转发器  
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");  
  
        String queueName = channel.queueDeclare().getQueue();  
        String severity = getSeverity();  
        // 指定binding_key  
        channel.queueBind(queueName, EXCHANGE_NAME, severity);  
        System.out.println(" [*] Waiting for "+severity+" logs. To exit press CTRL+C");  
  
        DeliverCallback deliverCallback =(consumerTag,delivery)->{
    	    String message = new String(delivery.getBody(),"UTF-8");
    	        System.out.println("[x] Received'" + message + "'");
    	    };
    	 channel.basicConsume(queueName,true,deliverCallback,consumerTag  -> {});
    }  
  
    /** 
     * 随机产生一种日志类型 
     *  
     * @return 
     */  
    private static String getSeverity()  
    {  
        Random random = new Random();  
        int ranVal = random.nextInt(3);  
        return SEVERITIES[ranVal];  
    }  
}