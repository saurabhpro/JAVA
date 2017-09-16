package com.saurabh.service;

import com.saurabh.model.ProductOrder;
import com.saurabh.service.factory.FreeMarkerTemplateFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class MailServiceImpl implements MailService<ProductOrder> {

	private final JavaMailSender mailSender;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public MailServiceImpl(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}


	@Override
	public void sendEmail(ProductOrder order) {

		MimeMessagePreparator preparator = getMessagePreparator(order);

		logger.info("Begin sending mail...");
		mailSender.send(preparator);
		logger.info("Message has been sent.............................");
	}

	private MimeMessagePreparator getMessagePreparator(ProductOrder order) {

		MimeMessagePreparator mimeMessagePreparator = new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				String messageBody;

				// use the true flag to indicate you need a multipart message
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

				helper.setSubject("Your order on Demo app with Templates");
				helper.setFrom("saurabhk1511@gmail.com");
				helper.setTo(order.getCustomerInfo().getEmail());

				Map<String, Object> model = new HashMap<>();
				model.put("order", order);  //this map is used in the freemarker template

				try {
					logger.info("Retrieving the email template...");
					messageBody = FreeMarkerTemplateFactory.geFreeMarkerTemplateContent(model);
				} catch (Exception e) {
					logger.warn("Exception occurred while processing fmtemplate:" + e.getMessage());
					logger.warn("Reset the messageBody to be sent in the mail to empty!");
					messageBody = "";
				}

				logger.info("Template content : \n" + messageBody);


				// use the true flag to indicate the text included is HTML
				//helper.setText("<html><body><img src='cid:identifier1234'></body></html>", true);

				helper.setText(messageBody, true);

				//Additionally, let's add a resource as an attachment as well.
				helper.addAttachment("cutie.png", new ClassPathResource("/static/img/linux-icon.png"));
			}
		};

		return mimeMessagePreparator;
	}

}
