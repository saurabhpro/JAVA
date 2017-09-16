package com.saurabh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by saurabhkumar on 05/04/17.
 */

@Controller
@RequestMapping("/hello")
public class ControllerRequestMaping {

	@RequestMapping("/showForm")
	public String showMore() {
		return "homeWithData";
	}
}
