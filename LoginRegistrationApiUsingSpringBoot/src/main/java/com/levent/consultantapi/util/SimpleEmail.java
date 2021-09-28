package com.levent.consultantapi.util;

import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SimpleEmail {

	public synchronized static String sendMailAdvance(String emailTo, String subject, String body, String attachment) {
		/*String host = "smtp.office365.com";
		String userName = "ankit.tyagi@nucleussoftware.com";
		String password = new String("JunJul@54321");
		String port = "587";*/
		
		String host = "smtp.gmail.com";
		final String userName = "shobhitperformance@gmail.com";
		final String password = new String("shyama@krishna");
		String port = "587";
		
		String starttls = "true";
		String socketFactoryClass = "javax.net.ssl.SSLSocketFactory";
		String fallback = "true";
		Properties props = null;
		Session session = null;
		MimeMessage mimeMessageg = null;

		try {

			props = System.getProperties();
			props.put("mail.smtp.user", userName);
			props.put("mail.smtp.host", host);
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.debug", "true");
			props.put("mail.smtp.ssl.trust", host);
			if (!"".equals(port)) {
				props.put("mail.smtp.port", port);
				props.put("mail.smtp.socketFactory.port", port);
			}
			if (!"".equals(starttls))
				props.put("mail.smtp.starttls.enable", starttls);
			if (!"".equals(socketFactoryClass))
				props.put("mail.smtp.socketFactory.class", socketFactoryClass);
			if (!"".equals(fallback))
				props.put("mail.smtp.socketFactory.fallback", fallback);
			session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(userName, password);
				}
			});

			mimeMessageg = new MimeMessage(session);
			mimeMessageg.setFrom(new InternetAddress(userName));
			mimeMessageg.setSubject(subject);
			mimeMessageg.setSentDate(new Date());
			mimeMessageg.setHeader("content-Type", "text/html;charset=\"ISO-8859-1\"");
			mimeMessageg.setContent(messageBodyPart(body, attachment));
			mimeMessageg.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
			mimeMessageg.saveChanges();
			Transport transport = session.getTransport("smtp");
			transport.connect(host, userName, password);
			transport.sendMessage(mimeMessageg, mimeMessageg.getAllRecipients());
			transport.close();
			return "Main Sent.";

		} catch (Exception exception) {
			exception.printStackTrace();
			return "Fail to Send Mail!";
		}
	}

	public static MimeMultipart messageBodyPart(String body, String attachment) {
		MimeMultipart multipart = new MimeMultipart();
		BodyPart messageBodyPart = null;
		try {
			if (!body.isEmpty()) {
				messageBodyPart = new MimeBodyPart();
				messageBodyPart.setText(body);
				multipart.addBodyPart(messageBodyPart);
			}

			if (!attachment.isEmpty()) {
				messageBodyPart = new MimeBodyPart();
				DataSource fds = new FileDataSource(attachment);
				messageBodyPart.setDataHandler(new DataHandler(fds));
				messageBodyPart.setFileName(attachment);
				multipart.addBodyPart(messageBodyPart);
			}

		} catch (Exception exception) {
			exception.getMessage();
		}
		return multipart;
	}
}