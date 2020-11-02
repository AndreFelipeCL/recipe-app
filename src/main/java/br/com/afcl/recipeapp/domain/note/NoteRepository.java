package br.com.afcl.recipeapp.domain.note;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 02/11/2020 - 17:26
 */
@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
