package udemy.saurabh.springguru104springmvcrecipies.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import udemy.saurabh.springguru104springmvcrecipies.model.Recipe;
import udemy.saurabh.springguru104springmvcrecipies.model.commands.RecipeCommand;
import udemy.saurabh.springguru104springmvcrecipies.model.exceptions.NotFoundException;
import udemy.saurabh.springguru104springmvcrecipies.service.IRecipeService;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class RecipeControllerTest {

	@Mock
	private IRecipeService recipeService;

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);

		RecipeController controller = new RecipeController(recipeService);
		mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setControllerAdvice(new ControllerExceptionHandler())
				.build();
	}

	@Test
	void testGetRecipe() throws Exception {

		Recipe recipe = new Recipe();
		recipe.setId(1L);

		when(recipeService.findById(anyLong())).thenReturn(recipe);

		mockMvc.perform(get("/recipe/1/show"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/show"))
				.andExpect(model().attributeExists("recipe"));
	}

	@Test
	void testGetNewRecipeForm() throws Exception {
		mockMvc.perform(get("/recipe/new"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/recipeform"))
				.andExpect(model().attributeExists("recipe"));
	}

	@Test
	void testPostNewRecipeForm() throws Exception {
		RecipeCommand command = new RecipeCommand();
		command.setId(2L);

		when(recipeService.saveRecipeCommand(any())).thenReturn(command);

		mockMvc.perform(post("/recipe/")
				.contentType(MediaType.APPLICATION_FORM_URLENCODED)
				.param("id", "")
				.param("description", "some string")
		)
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/recipe/2/show"));
	}


	@Test
	void testGetUpdateView() throws Exception {
		RecipeCommand command = new RecipeCommand();
		command.setId(2L);

		when(recipeService.findCommandById(anyLong())).thenReturn(command);

		mockMvc.perform(get("/recipe/1/update"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/recipeform"))
				.andExpect(model().attributeExists("recipe"));
	}

	@Test
	void testDeleteAction() throws Exception {
		mockMvc.perform(get("/recipe/1/delete"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/"));

		verify(recipeService, times(1)).deleteById(anyLong());
	}

	@Test
	void testGetRecipeNotFound404() throws Exception {

		when(recipeService.findById(anyLong())).thenThrow(NotFoundException.class);

		mockMvc.perform(get("/recipe/1/show"))
				.andExpect(status().isNotFound())
				.andExpect(view().name("404error"));
		;
	}

	@Test
	void testGetRecipeBadRequestNumberFormatException400() throws Exception {

		mockMvc.perform(get("/recipe/try/show"))
				.andExpect(status().isBadRequest())
				.andExpect(view().name("400error"));
		;
	}
}