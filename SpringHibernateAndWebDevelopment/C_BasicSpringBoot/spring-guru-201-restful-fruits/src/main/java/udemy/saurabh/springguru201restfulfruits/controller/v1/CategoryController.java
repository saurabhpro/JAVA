package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CategoryDTO;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CategoryListDTO;
import udemy.saurabh.springguru201restfulfruits.service.ICategoryService;

@Controller
@RequestMapping(CategoryController.BASE_URL)
public class CategoryController {

	static final String BASE_URL = "/api/v1/categories";

	private final ICategoryService categoryService;

	@Autowired
	public CategoryController(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@GetMapping
	public ResponseEntity<CategoryListDTO> getAllCategories() {
		return new ResponseEntity<>(new CategoryListDTO(categoryService.getAllCategories()), HttpStatus.OK);
	}

	@GetMapping("/{name}")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public CategoryDTO getCategoryByName(@PathVariable String name) {
		return categoryService.getCategoryByName(name);
	}
}