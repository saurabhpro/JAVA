package com.saurabh.controller.Rest;

import com.saurabh.model.User;
import com.saurabh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by saurabhkumar on 07/09/17.
 */
@RestController
public class HomeController {

	private UserService userService;

	@Autowired
	public HomeController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Handle request to the default page
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> viewHome() {
		return userService.findAllUsers();
	}

}
