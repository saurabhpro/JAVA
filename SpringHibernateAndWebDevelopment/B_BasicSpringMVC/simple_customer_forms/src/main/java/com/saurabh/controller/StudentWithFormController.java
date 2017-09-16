package com.saurabh.controller;

import com.saurabh.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saurabhkumar on 05/04/17.
 */
@Controller
@RequestMapping("/student")
public class StudentWithFormController {

	@RequestMapping("/showForm")
	public String showForm(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);

		return "student-form";

	}

	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {

		//log the sudent data
		System.out.println("The student's last name is - " + student.getLastName());
		return "student-confirmation";
	}
}
