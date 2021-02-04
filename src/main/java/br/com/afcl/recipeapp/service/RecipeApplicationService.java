package br.com.afcl.recipeapp.service;

import br.com.afcl.recipeapp.domain.recipe.Recipe;
import br.com.afcl.recipeapp.domain.recipe.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RecipeApplicationService {

	private final RecipeRepository recipeRepository;

	public Set<Recipe> findAll(){
		return new HashSet<>(recipeRepository.findAll());
	}

}
