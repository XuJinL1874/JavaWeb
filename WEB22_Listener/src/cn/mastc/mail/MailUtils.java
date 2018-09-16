package cn.mastc.mail;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	/**
	 * email:邮件发给谁 subject:主题 emailMsg:邮件内容
	 * @param email
	 * @param subject
	 * @param emailMsg
	 * @throws AddressException
	 * @throws MessagingException
	 */
	public static void sendMail(String email,String subject, String emailMsg)
			throws AddressException, MessagingException {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		// 发邮件的协议
		props.setProperty("mail.transport.protocol", "SMTP");
		// 发送邮件的服务器地址
		props.setProperty("mail.host", "localhost");
		// 指定验证为true
		props.setProperty("mail.smtp.auth", "true");

		// 创建验证器
		Authenticator auth = new Authenticator() {
			@Override
			public PasswordAuthentication getPasswordAuthentication() {
				// 发邮件的邮箱验证
				return new PasswordAuthentication("tom", "12345");
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		// 设置发送者
		message.setFrom(new InternetAddress("tom@itheima32.com"));

		// 设置发送方式与接收者
		message.setRecipient(RecipientType.TO, new InternetAddress(email));

		// 邮件的主题
		message.setSubject(subject);

		// 邮件的内容
		message.setContent(emailMsg, "text/html;charset=utf-8");

		// 3.创建 Transport用于将邮件发送

		Transport.send(message);
	}
}
