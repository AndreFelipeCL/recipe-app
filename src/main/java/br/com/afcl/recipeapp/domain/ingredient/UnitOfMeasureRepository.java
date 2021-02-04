package br.com.afcl.recipeapp.domain.ingredient;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 02/11/2020 - 17:28
 */
@Repository
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(final String description);

}
