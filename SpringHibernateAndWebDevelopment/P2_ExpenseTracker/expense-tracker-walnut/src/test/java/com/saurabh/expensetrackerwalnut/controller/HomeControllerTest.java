package com.saurabh.expensetrackerwalnut.controller;

import com.saurabh.expensetrackerwalnut.model.WalnutRow;
import com.saurabh.expensetrackerwalnut.service.IExpenseService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class HomeControllerTest {

	private HomeController homeController;

	@Mock
	private IExpenseService expenseService;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		homeController = new HomeController(expenseService);
	}

	@Test
	void getAllRows() {// given
		List<WalnutRow> recipeSet = new ArrayList<>();
		recipeSet.add(new WalnutRow());

		WalnutRow recipe = new WalnutRow();
		recipe.setID(22);
		recipeSet.add(recipe);

		// when
		when(expenseService.findAll()).thenReturn(recipeSet);
		List pageName = homeController.getAllRows();

		// then
		Assertions.assertEquals(2, pageName.size());
		verify(expenseService, times(1)).findAll();
	}


	@Test
	void mockMvc() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();

		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				//.andExpect(view().name("index"));
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(content().contentTypeCompatibleWith("application/json"))
				.andExpect(jsonPath("$", hasSize(0)));  // since data hasn't been loaded
	}

	@Test
	void getLastRow() {
	}

	@Test
	void getExpenseCount() {
	}

}