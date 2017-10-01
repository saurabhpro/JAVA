package com.saurabh.v6_mail_with_thymleaf.controller;

import com.saurabh.v6_mail_with_thymleaf.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by saurabhkumar on 15/09/17.
 */
@RestController
public class HomeController {

	private final OrderService orderService;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public HomeController(OrderService orderService) {
		this.orderService = orderService;
	}


	@RequestMapping("/simpleemail")
	public String home() {
		try {
			orderService.sendOrderConfirmation();
			return "Email Sent!";
		} catch (Exception ex) {
			logger.error("Error in sending email: " + ex);
			return "{result:failure}";
		}

	}

}
