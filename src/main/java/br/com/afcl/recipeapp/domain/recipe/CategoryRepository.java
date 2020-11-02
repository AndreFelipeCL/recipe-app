package br.com.afcl.recipeapp.domain.recipe;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 02/11/2020 - 17:25
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
