package com.saurabh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saurabhkumar on 04/04/17.
 */
@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public String showHome() {
		return "home";
	}
}
