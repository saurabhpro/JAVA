package com.saurabh.controller;

import com.saurabh.model.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * Created by saurabhkumar on 06/04/17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerClass {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		model.addAttribute("customer", new Customer());

		return "customer-form";
	}

	@RequestMapping("/processForm")
	public String processForm(
			@Valid @ModelAttribute("customer") Customer theCustomer, //validate on the model customer
			BindingResult bindingResult
	) {

		System.out.println("last name |" + theCustomer.getLastName() + "|");

		/*
		last name || - error
		last name |        | - passes if you dont trim the input
		 */
		if (bindingResult.hasErrors())
			return "customer-form";
		else
			return "customer-confirmation";
	}

	/**
	 * Pre-process any web request that comes in
	 *
	 * @param dataBinder the data
	 */
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		//propertyEditor
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		//trim to null if entire spaces


		//for every String - trim using the above code
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
}
