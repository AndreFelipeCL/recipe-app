package br.com.afcl.recipeapp.domain.ingredient;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

/**
 * @author André Felipe C. Leite
 * @version 1.0 18/02/2021
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UnitOfMeasureRepositoryTest {

	@Autowired
	private UnitOfMeasureRepository repository;

	@Test
	public void findByDescriptionTeaspoon() {
		Optional<UnitOfMeasure> unitOfMeasure = repository.findByDescription("Teaspoon");
		Assert.assertTrue(unitOfMeasure.isPresent());
		Assert.assertEquals(unitOfMeasure.get().getDescription(), "Teaspoon");
	}

	@Test
	public void findByDescriptionCup() {
		Optional<UnitOfMeasure> unitOfMeasure = repository.findByDescription("Cup");
		Assert.assertTrue(unitOfMeasure.isPresent());
		Assert.assertEquals(unitOfMeasure.get().getDescription(), "Cup");
	}

}