package udemy.saurabh.springguru104springmvcrecipies.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import udemy.saurabh.springguru104springmvcrecipies.model.commands.RecipeCommand;
import udemy.saurabh.springguru104springmvcrecipies.service.IRecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	private IRecipeService recipeService;

	public RecipeController(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@RequestMapping("/{id}/show")
	public String showById(@PathVariable String id, Model model) {

		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

		return "recipe/show";
	}

	@RequestMapping("/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";
	}

	@RequestMapping("/{id}/update")
	public String updateRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));
		return "recipe/recipeform";
	}

	@PostMapping
	@RequestMapping("/")
	public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}
}
