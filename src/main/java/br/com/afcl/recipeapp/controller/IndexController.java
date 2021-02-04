package br.com.afcl.recipeapp.controller;

import br.com.afcl.recipeapp.domain.recipe.Category;
import br.com.afcl.recipeapp.domain.recipe.CategoryRepository;
import br.com.afcl.recipeapp.domain.recipe.Recipe;
import br.com.afcl.recipeapp.service.RecipeApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.http.HTTPException;
import java.util.List;
import java.util.Set;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 12/10/2020 - 16:38
 */
@Controller
@RequiredArgsConstructor
public class IndexController {

	private final CategoryRepository categoryRepository;
	private final RecipeApplicationService recipeApplicationService;

	@RequestMapping({"", "/", "index"})
	public String getIndexPage() {
		return "index";
	}

	@GetMapping("/category/{categoryName}")
	@ResponseStatus(HttpStatus.FOUND)
	@ResponseBody
	public Category findCategoryByName(@PathVariable("categoryName") final String categoryName) {
		return categoryRepository.findOneByCategoryName(categoryName)
				.orElseThrow(() -> new HTTPException(HttpStatus.NOT_FOUND.value()));
	}

	@GetMapping("/recipe/all")
	@ResponseStatus(HttpStatus.OK)
	public String listAll(final Model model) {
		final Set<Recipe> recipeSet = recipeApplicationService.findAll();
		model.addAttribute("recipes", recipeSet);
		return "index";
	}

}
