package com.saurabh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saurabhkumar on 15/09/17.
 */
@Controller
public class EmailController {
	@GetMapping("/email")
	public String home2(){
		return "redirect:simpleemail";
	}
}
