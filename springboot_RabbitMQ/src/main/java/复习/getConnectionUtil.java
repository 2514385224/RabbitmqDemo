package ��ϰ;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class getConnectionUtil {

	public static Connection getConnection() throws Exception, Exception
	{
		//�������ӹ���
		ConnectionFactory factory = new ConnectionFactory();
	     factory.setHost("localhost");
	        factory.setPort(5672); //Ĭ�϶˿ں�
	        factory.setUsername("guest");//Ĭ���û���
	        factory.setPassword("guest");//Ĭ������
		
		//�����˺ţ��û���������
		//factory.setVirtualHost("/admin");
		
		
		//ͨ��������ȡ����
		Connection connection=factory.newConnection();
		
		return connection;
	}
}
