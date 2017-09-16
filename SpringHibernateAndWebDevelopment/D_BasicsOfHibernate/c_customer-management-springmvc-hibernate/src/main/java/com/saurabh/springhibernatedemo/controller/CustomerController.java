package com.saurabh.springhibernatedemo.controller;

import com.saurabh.springhibernatedemo.entity.Customer;
import com.saurabh.springhibernatedemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by saurabhkumar on 08/04/17.
 */
@Controller
@RequestMapping({"/customer", "/"})
public class CustomerController {

	//field injection is not recommended by Intellij
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	/*
	since the addition of service layer we use autowired service to delegate call to customerDAO
	private CustomerDAO customerDAO;    //works as @repository is at daoimpl so injected
	 */

	@GetMapping("/list")    //only handle GET, Request handles all types
	public String listCustomer(Model model) {
		//get the customer from dao
		List<Customer> customerList = customerService.getCustomers();

		//add the customers to model
		model.addAttribute("customers", customerList);

		return "list-customers";
	}


	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		// create model attribute to bind form data
		Customer theCustomer = new Customer();

		theModel.addAttribute("customer", theCustomer);

		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(/*MODEL ATTRIBUTE ON JSP FORM*/
	                           @ModelAttribute("customer") Customer theCustomer) {

		// save the customer using our service
		customerService.saveCustomer(theCustomer);


		return "redirect:/customer/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(/*this will come in the request*/
	                                @RequestParam("customerId") int theId,
	                                Model theModel) {

		// get the customer from our service
		Customer theCustomer = customerService.getCustomer(theId);

		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("customer", theCustomer);

		// send over to our form
		return "customer-form";
	}

	@GetMapping("/delete")
	public String deleteCustomer(/*this will come in the request*/
	                             @RequestParam("customerId") int theId) {

		// delete the customer
		customerService.deleteCustomer(theId);

		return "redirect:/customer/list";
	}
}
