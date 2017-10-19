package udemy.saurabh.springguru104springmvcrecipies.repositories;

import org.springframework.data.repository.CrudRepository;
import udemy.saurabh.springguru104springmvcrecipies.model.Category;

public interface ICategoryRepository extends CrudRepository<Category, Long> {
}
