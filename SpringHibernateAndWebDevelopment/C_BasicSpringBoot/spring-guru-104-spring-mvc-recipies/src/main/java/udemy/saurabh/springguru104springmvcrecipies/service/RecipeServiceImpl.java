package udemy.saurabh.springguru104springmvcrecipies.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import udemy.saurabh.springguru104springmvcrecipies.model.Recipe;
import udemy.saurabh.springguru104springmvcrecipies.repositories.IRecipeRepository;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements IRecipeService {

	private final IRecipeRepository recipeRepository;

	public RecipeServiceImpl(IRecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		log.info("I'm using slf4j");

		Set<Recipe> recipeSet = new HashSet<>();

		recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);

		return recipeSet;
	}
}