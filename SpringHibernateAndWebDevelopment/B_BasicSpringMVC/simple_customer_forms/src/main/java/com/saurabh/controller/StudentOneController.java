package com.saurabh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by saurabhkumar on 04/04/17.
 */
@Controller
public class StudentOneController {

	//controller method to show the basicform
	@RequestMapping("/showForm")
	public String getForm() {
		return "home-input";
	}

	//controller to process the form
	@RequestMapping("/processForm")
	public String processForm() {
		return "homeWithData";
	}


	//controller with request and Model to process the form
	@RequestMapping("/processFormDynamic")
	public String letsShowIT(HttpServletRequest request, Model model) {
		//read data form request
		String name = request.getParameter("studentName");

		//convert to all Uppercase
		name = name.toUpperCase();

		//create Cheerful message
		String result = "YO YO " + name;

		//add message to model
		model.addAttribute("message", result);


		return "homeWithData";
	}

	//controller with RequestParam and Model to process the form
	@RequestMapping("/processFormVersionThree")
	public String letsShowIT(@RequestParam("studentName") String name, Model model) {

		//convert to all Uppercase
		name = name.toUpperCase();

		//create Cheerful message
		String result = "YO  my man YO " + name;

		//add message to model
		model.addAttribute("message", result);
		System.out.println(result);

		return "homeWithData";
	}
}
