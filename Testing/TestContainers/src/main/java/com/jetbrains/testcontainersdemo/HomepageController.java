package com.jetbrains.testcontainersdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HomepageController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);

    private final CustomerDao customerDao;

    @Autowired
    public HomepageController(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GetMapping("/customers")
    public List<Customer> customers() {
        List<Customer> customers = customerDao.findAll();
        customers.forEach(c -> LOGGER.info("Found a customer: {}", c));
        return customers;
    }
}
