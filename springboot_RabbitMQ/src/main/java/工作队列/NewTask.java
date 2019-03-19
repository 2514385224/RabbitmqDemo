package 工作队列;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import java.io.IOException;
import java.util.concurrent.TimeoutException;
import com.rabbitmq.client.Channel;
public class NewTask {
	//队列
    private static final String QUEUE_NAME = "workqueue";
	public static void main(String[] args) throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();//连接工厂
		factory.setHost("localhost");//设置host
		Connection connection = factory.newConnection();//创建新的连接
		Channel channel = connection.createChannel();//创建一个通道
		
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);//声明一个队列		
		
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
