package com.ssm.controller;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import com.sun.mail.util.MailSSLSocketFactory;


public class SendHTMLEmail {

	 public static void main(String[] args) {

	        // 创建应用程序上下文
	        ApplicationContext actx = new ClassPathXmlApplicationContext("/mailMessage.xml");

	        // Spring 封装MailSender，不再重复造轮子
	        MailSender ms = (MailSender) actx.getBean("mailSender");

	        // 简单邮件发送
	        SimpleMailMessage smm = (SimpleMailMessage) actx.getBean("mailMessage");

	        // 主题,内容
	        smm.setSubject("你好");
	        smm.setText("这个是一个通过Spring框架来发送邮件的小程序");

	        // 发送
	        ms.send(smm);
	    }
	}
