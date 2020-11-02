package br.com.afcl.recipeapp.domain.ingredient;

import br.com.afcl.recipeapp.domain.recipe.Recipe;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 01/11/2020 - 23:02
 */
@Data
@Entity
public class Ingredient {

	@Id
	@SequenceGenerator(name = "INGREDIENT_ID_SEQ", sequenceName = "INGREDIENT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INGREDIENT_ID_SEQ")
	private Long id;

	private String description;

	private BigDecimal amount;

	@OneToOne
	private UnitOfMeasure unitOfMeasure;

	@ManyToOne
	private Recipe recipe;
}
