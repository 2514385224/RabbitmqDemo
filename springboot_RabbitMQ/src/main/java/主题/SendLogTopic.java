package ����;

import java.util.UUID;  

import com.rabbitmq.client.AMQP;  
import com.rabbitmq.client.Channel;  
import com.rabbitmq.client.Connection;  
import com.rabbitmq.client.ConnectionFactory;  

//������Ϣ��  
public class SendLogTopic {  
  private static final String EXCHANGE_NAME = "topic_logs";  
  public static void main(String[] args) throws Exception {  
      // �������Ӻ�Ƶ��    
      ConnectionFactory factory = new ConnectionFactory();    
      factory.setHost("192.168.101.174");  
  factory.setUsername("admin");  
      factory.setPassword("admin");  
      factory.setPort(AMQP.PROTOCOL.PORT);  
      Connection connection = factory.newConnection();    
      Channel channel = connection.createChannel();    
      // ����ת����  
      channel.exchangeDeclare(EXCHANGE_NAME, "topic");    
      //����󶨼�     
      String[] routing_keys = new String[] { "kernal.info", "cron.warning",    
              "auth.info", "kernel.critical" };    
      for (String routing_key : routing_keys)    
      {     
          //����4����ͬ�󶨼�����Ϣ  
          String msg = UUID.randomUUID().toString();    
          channel.basicPublish(EXCHANGE_NAME, routing_key, null, msg    
                  .getBytes());    
          System.out.println(" [x] Sent routingKey = "+routing_key+" ,msg = " + msg + ".");    
      }    
  
      channel.close();    
      connection.close();    
  }  

}  