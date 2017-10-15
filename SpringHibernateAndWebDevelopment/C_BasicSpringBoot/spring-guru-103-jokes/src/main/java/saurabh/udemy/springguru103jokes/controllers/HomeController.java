package saurabh.udemy.springguru103jokes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import saurabh.udemy.springguru103jokes.service.JokesProviderService;

@Controller
public class HomeController {

	private JokesProviderService jokesProviderService;

	@Autowired
	public HomeController(JokesProviderService jokesProviderService) {
		this.jokesProviderService = jokesProviderService;
	}

	@GetMapping({"/", ""})
	public String getJokes(Model model) {
		model.addAttribute("joke", this.jokesProviderService.getJokes());
		return "chuck-norris";
	}
}
