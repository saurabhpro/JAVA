package com.saurabh.service;

import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.ServerSetup;
import com.saurabh.model.ProductOrder;
import com.saurabh.service.factory.ProductFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Created by saurabhkumar on 16/09/17.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceImplTest {

	//TODO perfect testing??
	private GreenMail smtpServer;

	@Before
	public void setUp() throws Exception {
		smtpServer = new GreenMail(new ServerSetup(1025, null, "smtp"));
		smtpServer.start();
	}

	@After
	public void tearDown() throws Exception {
		smtpServer.stop();
	}

	@Autowired
	private MailServiceImpl mailClient;

	@Test
	public void shouldSendMail() throws Exception {
		//given
		ProductOrder productOrder = ProductFactory.getDummyOrder();
		//when
		mailClient.sendEmail(productOrder);
		//then
		assertReceivedMessageContains(productOrder.toString());
	}

	private void assertReceivedMessageContains(String expected) throws IOException, MessagingException {
		MimeMessage[] receivedMessages = smtpServer.getReceivedMessages();
		assertEquals(1, receivedMessages.length);

		String content = (String) receivedMessages[0].getContent();
		assertTrue(content.contains(expected));
	}

}