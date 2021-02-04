package br.com.afcl.recipeapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author André Felipe C. Leite
 * @version 1.0
 * @since 12/10/2020 - 16:38
 */
@Controller
public class IndexController {

	@RequestMapping({"", "/", "index"})
	public String getIndexPage() {
		return "index";
	}

}
