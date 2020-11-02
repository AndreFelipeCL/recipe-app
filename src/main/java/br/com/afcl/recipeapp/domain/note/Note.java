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
public class Note {

	@Id
	@SequenceGenerator(name = "NOTE_ID_SEQ", sequenceName = "NOTE_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTE_ID_SEQ")
	private Long id;

	@OneToOne
	private Recipe recipe;

	@Lob
	private String recipeNote;
}
