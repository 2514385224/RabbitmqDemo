package ��������;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
public class NewTask {
	//����
    private static final String QUEUE_NAME = "workqueue";
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();//���ӹ���
		factory.setHost("localhost");//����host
		Connection connection = factory.newConnection();//�����µ�����
		Channel channel = connection.createChannel();//����һ��ͨ��
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);//����һ������		
		
		String message = getMessage(args);
        for(int i=0;i<10;i++) {
        	channel.basicPublish("", QUEUE_NAME, null, (message+i).getBytes());
        	System.out.println(" [x] Sent '" +  (message+i) + "'");
        }	
		channel.close();
		connection.close();
	}
	private static String getMessage(String[] strings){
	    if (strings.length < 1)
	        return "Hello World!";
	    return joinStrings(strings, " ");
	}
	private static String joinStrings(String[] strings, String delimiter) {
	    int length = strings.length;
	    if (length == 0) return "";
	    StringBuilder words = new StringBuilder(strings[0]);
	    for (int i = 1; i < length; i++) {
	        words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	}
}
