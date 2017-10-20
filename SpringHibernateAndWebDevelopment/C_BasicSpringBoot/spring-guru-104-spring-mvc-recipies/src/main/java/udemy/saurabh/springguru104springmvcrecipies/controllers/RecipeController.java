package udemy.saurabh.springguru104springmvcrecipies.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import udemy.saurabh.springguru104springmvcrecipies.model.commands.RecipeCommand;
import udemy.saurabh.springguru104springmvcrecipies.service.IRecipeService;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {
	private IRecipeService recipeService;

	@Autowired
	public RecipeController(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/{id}/show")
	public String showById(@PathVariable String id, Model model) {

		model.addAttribute("recipe", recipeService.findById(Long.valueOf(id)));

		return "recipe/show";
	}

	@GetMapping("/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";
	}

	@GetMapping("/{id}/update")
	public String updateRecipe(@PathVariable String id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(Long.valueOf(id)));

		return "recipe/recipeform";
	}

	@PostMapping
	@RequestMapping("/")
	public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}

	@GetMapping("/{id}/delete")
	public String deleteById(@PathVariable String id) {

		log.debug("Deleting id: " + id);

		recipeService.deleteById(Long.valueOf(id));
		return "redirect:/";
	}
}
