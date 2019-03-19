package text;



import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jju.ssherb.enums.UserState;
import com.jju.sshweb.model.User;
import com.jju.sshweb.service.UserService;


public class SQLConfigTest {

	@Test
	public void test() throws Exception {
//		   List<String> warnings = new ArrayList<String>();
//		   boolean overwrite = true;
//		   String path=this.getClass().getClassLoader().getResource("MybatisConfig.xml").getPath();
//		   System.out.println(path);
//		   File configFile = new File("E:\\eclipse package location\\mybies\\ssh4\\src\\main\\resources\\mbgConfig.xml");
//		   System.out.println(configFile);
//		   ConfigurationParser cp = new ConfigurationParser(warnings);
//		   Configuration config;
//		   
//			config = cp.parseConfiguration(configFile);
//			System.out.println(config);
//			 DefaultShellCallback callback = new DefaultShellCallback(overwrite);
//			 MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
//			 myBatisGenerator.generate(null);
		
		ApplicationContext context=new ClassPathXmlApplicationContext("spring3.xml");
		
		UserService us=(UserService) context.getBean("userService");
		User u=new User();
		
		
		u.setState(UserState.ACTIVATION);
		
		us.insertSelective(u);
		
		
		
	}

}
