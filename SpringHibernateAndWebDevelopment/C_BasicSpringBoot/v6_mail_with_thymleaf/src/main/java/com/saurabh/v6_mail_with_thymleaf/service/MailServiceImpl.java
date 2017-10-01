package com.saurabh.v6_mail_with_thymleaf.service;

import com.saurabh.v6_mail_with_thymleaf.model.ProductOrder;
import com.saurabh.v6_mail_with_thymleaf.service.factory.FreeMarkerTemplateFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

/**
 * The send() method is overloaded and accepts several types of parameters:
 * <p>
 * SimpleMailMessage – As the name suggests this is a basic model of a mail message so only the most common properties can be assigned. It doesn’t allow modifying message headers and transports only plain text content.
 * MimeMessage – Complex mail message model provided by javax.mail library.
 * MimeMessagePreparator – An interface which provides a builder template method for MimeMessage and alleviates exception handling while creating an instance of the type. The official documentation (but also common sense :)) suggests MimeMessagePreparator as the preferred type for mail message building.
 * The MimeMessageHelper class is a decorator for MimeMessage that provides more developer friendly interface and adds input validation for many properties of the class. You don’t have to use it, but you definitely won’t regret trying.
 * <p>
 * Note, that the send() method throws MailException which is a subclass of RuntimeException. In case of failure in message delivery, most likely you would like to repeat the send action or at least handle the unpleasant situation with some more sophisticated solution like … logging the error message with the corresponding stack trace.
 */

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
				helper.setFrom("surabhikulkarni2692@gmail.com");
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
