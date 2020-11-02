package br.com.afcl.recipeapp.domain.recipe;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 02/11/2020 - 14:36
 */
@Data
@Entity
public class Category {

	@Id
	@SequenceGenerator(name = "CATEGORY_ID_SEQ", sequenceName = "CATEGORY_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ID_SEQ")
	private Long id;

	private String categoryName;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categories")
	private Set<Recipe> recipe;
}
