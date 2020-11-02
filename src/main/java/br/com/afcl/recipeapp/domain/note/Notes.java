package br.com.afcl.recipeapp.domain.note;

import br.com.afcl.recipeapp.domain.recipe.Recipe;
import lombok.Data;

import javax.persistence.*;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 01/11/2020 - 21:48
 */
@Data
@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Recipe recipe;

	@Lob
	private String recipeNotes;
}
