package ��ϰ;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * ��ģʽ,�����߷�����Ϣ�������ߴӶ�����ȥ��Ϣ
 * һ����Ϣ��Ӧһ��������
 * 
 * @author 2514385224
 *
 */
public class Send1 {

	private final static String QUEUE_NAME="testhello";
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Connection connection=getConnectionUtil.getConnection();
		
		//�������д���ͨ��
		
		Channel channel=connection.createChannel();
		
		//�������У���������ھʹ�����
		/**
		 * ����1:������
		 * ����2: durable:�Ƿ�־û������е������Ǵ�ŵ��ڴ��У����rabbimq������
		 * �ᶪʧ������������󻹴��ھ�ʹ���г־û������浽Erlang�Դ���Mnesia���ݿ��У���Rabbitmq������Զ�ȡ�����ݿ�
		 * 
		 * 
		 * 
		 */
		channel.queueDeclareNoWait(QUEUE_NAME, false, false, false, null);
		
		String message="Hello World!";
		
		//����1:���������˴�û�У�����2�����͵��Ǹ����У�����3������   ����4:����
		
		channel.basicPublish("", QUEUE_NAME,null, message.getBytes());
		
		System.out.println("�������ݣ���"+message+"'");
		
		//�ر�ͨ����������
		
		channel.close();
		connection.close();
		
		
		
		
		
	}

}
