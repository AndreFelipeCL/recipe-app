package br.com.afcl.recipeapp.service;

import br.com.afcl.recipeapp.domain.recipe.Recipe;
import br.com.afcl.recipeapp.domain.recipe.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.verification.VerificationMode;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author André Felipe C. Leite
 * @version 1.0 12/02/2021
 */
class RecipeApplicationServiceTest {

	private RecipeApplicationService recipeApplicationService;

	@Mock
	private RecipeRepository recipeRepository;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		this.recipeApplicationService = new RecipeApplicationService(this.recipeRepository);
	}

	@Test
	public void shouldReturnRecipes() {
		final List<Recipe> expectedRecipes = Stream.of(
				new Recipe(), new Recipe()
		).collect(Collectors.toList());

		Mockito.when(recipeRepository.findAll()).thenReturn(expectedRecipes);

		final Set<Recipe> recipes = recipeApplicationService.findAll();
		Assertions.assertEquals(recipes.size(), 2);
		Mockito.verify(recipeRepository, Mockito.atMostOnce()).findAll();
	}
}