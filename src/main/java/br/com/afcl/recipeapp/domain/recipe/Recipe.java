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
	@SequenceGenerator(name = "RECIPE_ID_SEQ", sequenceName = "RECIPE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RECIPE_ID_SEQ")
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

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "recipe_category",
			joinColumns = @JoinColumn(name = "recipe_id", nullable = false, referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "category_id", nullable = false, referencedColumnName = "ID"))
	private Set<Category> categories;
}
