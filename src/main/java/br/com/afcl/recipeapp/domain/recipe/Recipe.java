package br.com.afcl.recipeapp.domain.recipe;

import br.com.afcl.recipeapp.domain.ingredient.Ingredient;
import br.com.afcl.recipeapp.domain.note.Notes;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 01/11/2020 - 21:42
 */
@Data
@Entity
public class Recipe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private Integer preparationTime;

	private Integer cookTime;

	private Integer serving;

	private String source;

	private String url;

	private String directions;

	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;

	@Lob
	private Byte[] image;

	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients;
}
