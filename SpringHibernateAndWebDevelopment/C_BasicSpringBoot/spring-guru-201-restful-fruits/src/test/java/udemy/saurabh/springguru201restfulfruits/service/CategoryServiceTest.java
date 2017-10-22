package udemy.saurabh.springguru201restfulfruits.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICategoryMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CategoryDTO;
import udemy.saurabh.springguru201restfulfruits.model.Category;
import udemy.saurabh.springguru201restfulfruits.repository.ICategoryRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CategoryServiceTest {

	private static final Long ID = 2L;
	private static final String NAME = "Jimmy";
	private ICategoryService categoryService;

	@Mock
	private ICategoryRepository categoryRepository;


	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		categoryService = new CategoryServiceImpl(ICategoryMapper.INSTANCE, categoryRepository);
	}

	@Test
	public void getAllCategories() throws Exception {

		//given
		List<Category> categories = Arrays.asList(new Category(), new Category(), new Category());

		when(categoryRepository.findAll()).thenReturn(categories);

		//when
		List<CategoryDTO> categoryDTOS = categoryService.getAllCategories();

		//then
		assertEquals(3, categoryDTOS.size());

	}

	@Test
	public void getCategoryByName() throws Exception {

		//given
		Category category = new Category();
		category.setId(ID);
		category.setName(NAME);

		when(categoryRepository.findByName(anyString())).thenReturn(category);

		//when
		CategoryDTO categoryDTO = categoryService.getCategoryByName(NAME);

		//then
		assertEquals(ID, categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());

	}

}