package com.saurabh.v5_gmail_email_send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;

@Controller
public class SimpleEmailController3 {

	@Autowired
	private JavaMailSender sender;

	@RequestMapping("/simpleemail3")
	@ResponseBody
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

		// Enable the multipart flag!
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo("saurabhk15@outlook.com");
		helper.setText("<html><body>Here is a cat picture! <img src='cid:id101'/><body></html>", true);
		helper.setSubject("Hi");

		ClassPathResource file = new ClassPathResource("/static/img/cat.jpg");
		helper.addInline("id101", file);

		sender.send(message);
	}
}