package 复习;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class getConnectionUtil {

	public static Connection getConnection() throws Exception, Exception
	{
		//定义连接工厂
		ConnectionFactory factory = new ConnectionFactory();
	     factory.setHost("localhost");
	        factory.setPort(5672); //默认端口号
	        factory.setUsername("guest");//默认用户名
	        factory.setPassword("guest");//默认密码
		
		//设置账号，用户名，密码
		//factory.setVirtualHost("/admin");
		
		
		//通过工厂获取连接
		Connection connection=factory.newConnection();
		
		return connection;
	}
}
