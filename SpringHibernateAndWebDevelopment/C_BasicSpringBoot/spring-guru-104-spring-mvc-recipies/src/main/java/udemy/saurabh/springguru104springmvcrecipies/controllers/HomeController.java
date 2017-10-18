package udemy.saurabh.springguru104springmvcrecipies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"","/","index"})
	String getMo (Model model){
		return "index";
	}
}
