package com.saurabh;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SimpleEmailController5 {

	@Autowired
	private JavaMailSender sender;

	@Qualifier("freeMarkerConfiguration")
	@Autowired
	private Configuration freemarkerConfig;

	@RequestMapping("/simpleemail5")
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

		MimeMessageHelper helper = new MimeMessageHelper(message);

		Map<String, Object> model = new HashMap<>();
		model.put("user", "sk");

		// set loading location to src/main/resources
		// You may want to use a subfolder such as /templates here
		freemarkerConfig.setClassForTemplateLoading(this.getClass(), "/");

		Template t = freemarkerConfig.getTemplate("/templates/welcome.ftl");
		String text = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

		helper.setTo("saurabhk1511@gmail.com");
		helper.setText(text, true); // set to html
		helper.setSubject("Hi");

		sender.send(message);
	}
}