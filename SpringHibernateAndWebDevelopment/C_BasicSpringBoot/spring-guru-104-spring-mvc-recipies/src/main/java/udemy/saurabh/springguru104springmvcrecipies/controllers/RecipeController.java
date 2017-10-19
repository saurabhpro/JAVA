package udemy.saurabh.springguru104springmvcrecipies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import udemy.saurabh.springguru104springmvcrecipies.service.IRecipeService;

@Controller
public class RecipeController {
	private IRecipeService recipeService;

	public RecipeController(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/recipe/show/{id}")
	String getRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

		return "recipe/show";
	}
}
