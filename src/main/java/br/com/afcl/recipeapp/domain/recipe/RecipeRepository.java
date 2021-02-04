package br.com.afcl.recipeapp.domain.recipe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 02/11/2020 - 17:21
 */
@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>, JpaRepository<Recipe, Long> {
}
