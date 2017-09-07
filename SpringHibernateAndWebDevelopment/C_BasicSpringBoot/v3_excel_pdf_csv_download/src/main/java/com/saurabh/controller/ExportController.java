package com.saurabh.controller;

import com.saurabh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExportController {

	private final UserService userService;

	@Autowired
	public ExportController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Handle request to download an Excel document
	 */
	@GetMapping(value = "/download")
	public String download(Model model) {
		model.addAttribute("users", userService.findAllUsers());
		return "";
	}


}
