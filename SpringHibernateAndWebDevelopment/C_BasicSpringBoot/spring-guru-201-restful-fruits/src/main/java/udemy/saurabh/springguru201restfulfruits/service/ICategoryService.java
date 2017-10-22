package udemy.saurabh.springguru201restfulfruits.service;

import udemy.saurabh.springguru201restfulfruits.api.v1.model.CategoryDTO;

import java.util.List;

public interface ICategoryService {
	List<CategoryDTO> getAllCategories();

	CategoryDTO getCategoryByName(String name);
}
