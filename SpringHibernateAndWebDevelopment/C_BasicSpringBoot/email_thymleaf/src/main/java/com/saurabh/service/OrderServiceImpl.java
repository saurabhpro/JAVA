package com.saurabh.service;

import com.saurabh.model.ProductOrder;
import com.saurabh.service.factory.ProductFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

	private final MailService<ProductOrder> mailService;


	private Logger logger = LoggerFactory.getLogger(this.getClass());


	@Autowired
	public OrderServiceImpl(MailService<ProductOrder> mailService) {
		this.mailService = mailService;
	}

	@Override
	public void sendOrderConfirmation() {
		logger.info("Getting dummy product...");
		ProductOrder productOrder = ProductFactory.getDummyOrder();

		mailService.sendEmail(productOrder);
	}

}
