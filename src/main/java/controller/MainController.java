package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Recipe;
import services.RecipeService;

@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	RecipeService recipeService;
	
	   @GetMapping("/recipes")
	    public List <Recipe> getAllRecipes() {
	        return RecipeService.getALLRecipes();
	    }
	@GetMapping("/recipes{id}")
	public Recipe getRecipe(@PathVariable("id") int id) {
		return RecipeService.getRecipeById(id);
	}

	@DeleteMapping("/recipes/{id}")
	private void deleteRecipe(@PathVariable("id") int id) {
		System.out.println("Delete");
		recipeService.delete(id);
	}
	
	@PostMapping("/recipes")
	private int saveRecipe(@RequestBody Recipe recipe) {
		recipeService.saveOrUpdate(recipe);
	
		return recipe.getId();
	}
	@PutMapping("/recipes/{id}")
	public ResponseEntity<?> updateRecipe(@PathVariable("id") int id, @RequestBody Recipe recipe) {
		recipeService.saveOrUpdate(recipe);
		return ResponseEntity.ok("PUT");
	}

	
}
