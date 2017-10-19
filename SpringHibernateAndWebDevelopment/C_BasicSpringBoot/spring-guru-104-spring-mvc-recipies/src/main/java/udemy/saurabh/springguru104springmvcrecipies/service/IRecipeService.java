package udemy.saurabh.springguru104springmvcrecipies.service;

import udemy.saurabh.springguru104springmvcrecipies.model.Recipe;

import java.util.Set;

public interface IRecipeService {

	Set<Recipe> getRecipes();
}
