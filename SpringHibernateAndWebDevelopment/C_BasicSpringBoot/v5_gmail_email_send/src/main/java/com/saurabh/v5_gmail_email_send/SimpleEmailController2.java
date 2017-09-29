package com.saurabh.v5_gmail_email_send;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;

@RestController
public class SimpleEmailController2 {

	private final JavaMailSender sender;

	@Autowired
	public SimpleEmailController2(JavaMailSender sender) {
		this.sender = sender;
	}

	@RequestMapping("/simpleemail2")
	String home() {
		try {
			sendEmail();
			return "Email Sent!";
		} catch (Exception ex) {
			return "Error in sending email: " + ex;
		}
	}

	/**
	 * The following controller sends an email with a picture attached to it.
	 * We load a cat picture from the classpath.
	 * Before running this example, ensure that you have a cat.jpg file copied to the src/main/resources folder.
	 * <p>
	 * Note that the above controller is configured on a different path(/simpleemail2).
	 * Also note the multipart flag passed as the second parameter to MimeMessageHelper constructor.
	 * If this is not set to true, you will get the following error,
	 * java.lang.IllegalStateException: Not in multipart mode – create an appropriate MimeMessageHelper via a constructor that takes a ‘multipart’ flag if you need to set alternative texts or add inline elements or attachments.
	 *
	 * @throws Exception just for showing the right message
	 */
	private void sendEmail() throws Exception {
		MimeMessage message = sender.createMimeMessage();

		// Enable the multipart flag!
		MimeMessageHelper helper = new MimeMessageHelper(message, true);

		helper.setTo("saurabhk1511@gmail.com");
		helper.setText("How are you?");
		helper.setSubject("Hi");

		ClassPathResource file = new ClassPathResource("/static/img/cat.jpg");
		helper.addAttachment("cat.jpg", file);

		sender.send(message);
	}
}