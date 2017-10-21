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
	private final IRecipeService recipeService;

	@Autowired
	public RecipeController(IRecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/{id}/show")
	public String showById(@PathVariable Long id, Model model) {

		log.info("@PathVariable Type is Recipe id or Long id instead of String id & it works");

		model.addAttribute("recipe", recipeService.findById(id));

		return "recipe/show";
	}

	@GetMapping("/new")
	public String newRecipe(Model model) {
		model.addAttribute("recipe", new RecipeCommand());

		return "recipe/recipeform";
	}

	@GetMapping("/{id}/update")
	public String updateRecipe(@PathVariable Long id, Model model) {
		model.addAttribute("recipe", recipeService.findCommandById(id));

		return "recipe/recipeform";
	}

	@PostMapping("/")
	public String saveOrUpdate(@ModelAttribute RecipeCommand command) {
		RecipeCommand savedCommand = recipeService.saveRecipeCommand(command);

		return "redirect:/recipe/" + savedCommand.getId() + "/show";
	}

	@GetMapping("/{id}/delete")
	public String deleteById(@PathVariable Long id) {

		log.debug("Deleting id: " + id);

		recipeService.deleteById(id);

		return "redirect:/";    // to home controller
	}
}

/*
@PathVariable Type valueName(from URI)

here the Type can be anything you need, given thats what you need
for our id - we could gave used

@PathVariable Recipe id or
@PathVariable Long id or
@PathVariable String id

by using @Long id - no boxing was required
 */