package br.com.afcl.recipeapp.domain.ingredient;

import lombok.Data;

import javax.persistence.*;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 01/11/2020 - 23:04
 */
@Data
@Entity
public class UnitOfMeasure {

	@Id
	@SequenceGenerator(name = "INGREDIENT_ID_SEQ", sequenceName = "INGREDIENT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "INGREDIENT_ID_SEQ")
	private Long id;

	private String description;
}
