package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import entity.Recipe;
import services.RecipeService;

@Controller
public class MainController {
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		List<Recipe> listrecipe = recipeService.listAll();
		model.addAttribute("listrecipe", listrecipe);
		System.out.print("Get /");
		return "index";
	}
	
	@GetMapping("/new")
	public String add(Model model ) {
	model.addAttribute("recipe", new Recipe());
	return "new";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveRecipe (@ModelAttribute ("recipe") Recipe std) {
		recipeService.save(std);
		return "redirect:/";
	}
		
	@RequestMapping("edit/{id}")
	public ModelAndView showEditRecipePage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView ("new");
		Recipe std = recipeService.get(id);
		mav.addObject("recipe", std);
		return mav;
	} 
		
		
	/**
	
	   @GetMapping("/recipes")
	    public ArrayList <Recipe> getAllRecipes() {
	        return recipeService.getAllRecipes();
	    }
	   
	@GetMapping("/recipes{id}")
	public List<Recipe> getRecipe(@PathVariable("id") int id) {
		return recipeService.getRecipeById(id);
	}

	@DeleteMapping("/recipes/{id}")
	private void deleteRecipe(@PathVariable("id") int id) {
		System.out.println("Delete");
		recipeService.deleteRecipeId(id);
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
*/
	
	
}
