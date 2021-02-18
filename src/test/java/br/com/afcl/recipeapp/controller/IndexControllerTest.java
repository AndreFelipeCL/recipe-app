package br.com.afcl.recipeapp.controller;

import br.com.afcl.recipeapp.domain.recipe.Recipe;
import br.com.afcl.recipeapp.service.RecipeApplicationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author André Felipe C. Leite
 * @version 1.0 12/02/2021
 */
class IndexControllerTest {

	@Mock
	private RecipeApplicationService service;

	@Mock
	private Model model;

	private IndexController controller;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		this.controller = new IndexController(this.service);
	}

	@Test
	public void getIndexPage() {
		//Given
		final Set<Recipe> expectedRecipes = Stream.of(
				new Recipe(), new Recipe()
		).collect(Collectors.toSet());
		Mockito.when(this.service.findAll()).thenReturn(expectedRecipes);

		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

		//When
		final String viewIndex = controller.listAll(this.model);

		//Then
		Assertions.assertEquals("index", viewIndex);
		Mockito.verify(service, Mockito.atMostOnce()).findAll();
		Mockito.verify(this.model, Mockito.atMostOnce()).addAttribute(Mockito.eq("recipes"), argumentCaptor.capture());
		Set<Recipe> argumentCaptorValue = argumentCaptor.getValue();
		Assertions.assertEquals(2, argumentCaptorValue.size());
		Assertions.assertEquals(expectedRecipes, argumentCaptorValue);
	}

	@Test
	public void testMockMvc() throws Exception {
		final MockMvc mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("index"));
	}
}