package udemy.saurabh.springguru104springmvcrecipies.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.saurabh.springguru104springmvcrecipies.model.Recipe;

public interface IRecipeRepository extends CrudRepository<Recipe, Long> {
}
