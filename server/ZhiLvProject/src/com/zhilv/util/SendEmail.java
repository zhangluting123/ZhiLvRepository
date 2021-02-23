package com.zhilv.util;

import java.util.Date;
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

/**
 * 
 * @ClassName: SendEmail   
 * @Description:
 * @author: 张璐婷
 * @date: 2021年2月21日 下午9:28:37
 */

public class SendEmail {
	
	public static void sendEmailMessage(String email, long n) {
		// Get system properties
		Properties props = System.getProperties();
		// Setup mail server
		props.put("mail.smtp.host", "smtp.tom.com");
		props.put("mail.smtp.auth", "true");

		// Get Session
		Session session = Session.getInstance(props, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("3588652297", "tqyqxnrsevvrchhi"); //用户名 授权码
			}
		});

		// Define message
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress("3588652297@qq.com")); //发件人
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email)); //收件人
			message.setSubject("知旅的验证码码"); //标题
			message.setContent("<span style='font-size:18px;'>您本次的验证码为：</span>"+"<span style='font-weight:blue;font-size:20px'>"+n+"</span>",
                "text/html;charset=gbk");
			// send message
			message.setHeader("X-Mailer", "smtpsend"); ////以smtpsend名义发送邮件，不会被当作垃圾邮件 
			message.setSentDate(new Date());
			Transport.send(message);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}


}
