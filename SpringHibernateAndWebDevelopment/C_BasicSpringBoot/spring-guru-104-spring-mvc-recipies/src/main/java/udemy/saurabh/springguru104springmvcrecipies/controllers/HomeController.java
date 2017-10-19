package udemy.saurabh.springguru104springmvcrecipies.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import udemy.saurabh.springguru104springmvcrecipies.service.IRecipeService;

@Slf4j
@Controller
public class HomeController {

	private IRecipeService recipeService;

	public HomeController(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping({"","/","index"})
	String getMo (Model model){
		model.addAttribute("recipes", this.recipeService.getRecipes());
		return "index";
	}
}
