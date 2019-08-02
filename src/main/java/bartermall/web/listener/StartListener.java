package bartermall.web.listener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class StartListener implements ServletContextListener {

	@Autowired
	private JavaMailSender javaMailSender;

	// 服务器主机名 smtp.xx.commail.smtp.host=smtp.qq.com
	@Value("${mail.smtp.host}")
	private String host;

	@Value("${mail.smtp.port}")
	private int port;
	// 密码/客户端授权码mail.smtp.password=njvqgowoelepbfaa
	@Value("${mail.smtp.password}")
	private String password;
	// #编码字符mail.smtp.defaultEncoding=utf-8
	@Value("${mail.smtp.defaultEncoding}")
	private String defaultEncoding;
	// #是否进行用户名密码校验mail.smtp.auth=true
	// #设置超时时间mail.smtp.timeout=20000
	@Value("${mail.smtp.timeout}")
	private int timeout;
	// #发送主题mail.smtp.setSubject=易货交易平台
	@Value("${mail.smtp.setSubject}")
	private String setSubject;
	// #设置发送内容mail.smtp.text=
	@Value("${mail.smtp.text}")
	private String text;
	@Value("${mail.smtp.username}")
	private String username;
	@Value("${mail.smtp.tousername}")
	private String tousername;


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		// 出生时候
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
		message.setTo("923972487@qq.com");
		//message.setTo("2495440096@qq.com");
		message.setSubject("易货交易平台");
		//日期处理
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		message.setText("易货交易平台启动成功,启动时间为："+	dateFormat.format(new Date()));
		// 发送邮件
		mailSender.send(message);	


	}

	// 销毁时候
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
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
		message.setSubject("易货交易平台");
		//日期处理
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		message.setText("易货交易平台准备关闭,关闭时间为："+	dateFormat.format(new Date()));
		// 发送邮件
		mailSender.send(message);

	}

	/**
	 ** 
	 * @Description:没用spring整合，可以发送
	 * @param:
	 * @return: void
	 */
	public void JavaMail() {
		// 创建邮件发送服务器
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost(host);
		//
		mailSender.setPort(port);
		mailSender.setUsername(username);
		mailSender.setPassword(password);
		// 加认证机制
		Properties javaMailProperties = new Properties();
		javaMailProperties.put("mail.smtp.auth", true);
		javaMailProperties.put("mail.smtp.starttls.enable", true);
		javaMailProperties.put("mail.smtp.timeout", timeout);
		mailSender.setJavaMailProperties(javaMailProperties);
		// 创建邮件内容
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(username);
		message.setTo(tousername);
		message.setSubject(setSubject);
		message.setText(text);
		// 发送邮件
		mailSender.send(message);
		System.out.println("易货交易平台启动成功_" + new Date());
	}

	/**
	 ** 
	 * @Description:报错，报JavaMailSender空指针
	 * @param:
	 * @return: void
	 */
	public void SpringMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		// 发件人的邮箱地址
		message.setFrom(username);
		// 收件人的邮箱地址
		message.setTo(username);
		// 邮件主题
		message.setSubject("spring email test!!!!");
		// 邮件内容
		message.setText("收到的邮件内容：易货交易平台启动成功！！！");
		// 发送邮件
		JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
		javaMailSenderImpl.setHost("smtp.qq.com");
		javaMailSenderImpl.setUsername("923972487@qq.com");
		javaMailSenderImpl.setPassword("njvqgowoelepbfaa");
		javaMailSenderImpl.setPort(587);
		javaMailSenderImpl.send(message);

		System.out.println("易货交易平台启动成功_" + new Date());
	}

}
