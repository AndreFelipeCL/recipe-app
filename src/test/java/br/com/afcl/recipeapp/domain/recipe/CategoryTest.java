package br.com.afcl.recipeapp.domain.recipe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author André Felipe C. Leite
 * @version 1.0 12/02/2021
 */
class CategoryTest {

	Category category;

	@BeforeEach
	public void setUp() {
		category = new Category();
	}

	@Test
	void getId() {
		final Long expectedId = 4L;
		category.setId(expectedId);
		Assertions.assertEquals(expectedId, category.getId());
	}

	@Test
	void getCategoryName() {
		final String expectedName = "Category Test Junit 5";
		category.setCategoryName(expectedName);
		Assertions.assertEquals(expectedName, category.getCategoryName());
	}

	@Test
	void getRecipe() {
		final Set<Recipe> expectedRecipes = Stream.of(
				new Recipe(), new Recipe()
		).collect(Collectors.toSet());
		category.setRecipe(expectedRecipes);
		Assertions.assertEquals(expectedRecipes, category.getRecipe());
	}
}