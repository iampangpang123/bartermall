package bartermall;

import java.util.Properties;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class TestMail {

	// @Value("${mail.smtp.username}")
//	private String emailFrom;//发件人名称

	@Value("${mail.smtp.username}") // 收件人名称
	private String toEmail;

	/**
	 **   
	 * @Description:通过spring方式发送
	 * @param:       
	 * @return: void      
	 */
	@Test
	public void test1() {
		// ApplicationContext applicationContext = new
		// ClassPathXmlApplicationContext("classpath:*.xml");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"classpath:applicationContext-dao.xml");
		JavaMailSender javaMailSender = applicationContext.getBean(JavaMailSender.class);
		SimpleMailMessage message = new SimpleMailMessage();
		// 发件人的邮箱地址
		message.setFrom(toEmail);
		// 收件人的邮箱地址
		message.setTo(toEmail);
		// 邮件主题
		message.setSubject("spring email test!!!!");
		// 邮件内容
		message.setText("收到的邮件内容：spring email test ！！！");
		// 发送邮件
		javaMailSender.send(message);

	}

	/**
	 **   
	 * @Description:传统方式
	 * @param:       
	 * @return: void      
	 */
	@Test
	public void test2() {
		// 创建邮件发送服务器
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.qq.com");
		//
		mailSender.setPort(587);
		mailSender.setUsername("923972487@qq.com");
		mailSender.setPassword("njvqgowoelepbfaa");
		// 加认证机制
		Properties javaMailProperties = new Properties();
		 javaMailProperties.put("mail.smtp.auth", true);
		 javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put("mail.smtp.timeout", 5000);
		mailSender.setJavaMailProperties(javaMailProperties);
		// 创建邮件内容
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("923972487@qq.com");
		message.setTo("iamispangpang@163.com");
		message.setSubject("aaaaaaaaaaaaaa");
		message.setText("aaaaaaaaaaaaaaaaaa");
		// 发送邮件
		mailSender.send(message);

	}
}
