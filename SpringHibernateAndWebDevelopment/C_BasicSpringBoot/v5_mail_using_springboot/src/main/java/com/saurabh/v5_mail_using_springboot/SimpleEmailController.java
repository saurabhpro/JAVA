package com.saurabh.v5_gmail_email_send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
public class SimpleEmailController {

	private final JavaMailSender sender;

	@Autowired
	public SimpleEmailController(JavaMailSender sender) {
		this.sender = sender;
	}

	@RequestMapping("/simpleemail")
	String home() {
		try {
			sendEmail();
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}

	private void sendEmail() throws Exception {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setTo("saurabhk1511@gmail.com");
		helper.setText("How are you?");
		helper.setSubject("Hi");

		sender.send(message);
	}
}