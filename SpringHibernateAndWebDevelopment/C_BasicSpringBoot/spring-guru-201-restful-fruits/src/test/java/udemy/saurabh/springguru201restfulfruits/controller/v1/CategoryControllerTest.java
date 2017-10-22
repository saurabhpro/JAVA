package udemy.saurabh.springguru201restfulfruits.controller.v1;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CategoryDTO;
import udemy.saurabh.springguru201restfulfruits.controller.RestResponseEntityExceptionHandler;
import udemy.saurabh.springguru201restfulfruits.model.exceptions.ResourceNotFoundException;
import udemy.saurabh.springguru201restfulfruits.service.ICategoryService;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class CategoryControllerTest {

	private static final String NAME = "Jim";
	private static final String API_V1_CATEGORIES = CategoryController.BASE_URL + "/";

	@Mock
	private
	ICategoryService categoryService;

	@InjectMocks
	private    // inject @Mock to this controller, so no need to do controller = new Contoller(service)
			CategoryController categoryController;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		mockMvc = MockMvcBuilders.standaloneSetup(categoryController)
				.setControllerAdvice(new RestResponseEntityExceptionHandler())
				.build();

	}

	@Test
	public void testListCategories() throws Exception {
		CategoryDTO category1 = new CategoryDTO();
		category1.setId(1L);
		category1.setName(NAME);

		CategoryDTO category2 = new CategoryDTO();
		category2.setId(2L);
		category2.setName("Bob");

		List<CategoryDTO> categories = Arrays.asList(category1, category2);

		when(categoryService.getAllCategories()).thenReturn(categories);

		mockMvc.perform(get(API_V1_CATEGORIES)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.categories", hasSize(2)));
	}

	@Test
	public void testGetByNameCategories() throws Exception {
		CategoryDTO category1 = new CategoryDTO();
		category1.setId(1L);
		category1.setName(NAME);

		when(categoryService.getCategoryByName(anyString())).thenReturn(category1);

		mockMvc.perform(get(API_V1_CATEGORIES + NAME)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.name", equalTo(NAME)));
	}

	@Test
	public void testGetByNameNotFound() throws Exception {

		when(categoryService.getCategoryByName(anyString())).thenThrow(ResourceNotFoundException.class);

		mockMvc.perform(get(CategoryController.BASE_URL + "/Foo")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());
	}
}