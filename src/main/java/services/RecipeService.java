package services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RecipeDao;
import entity.Recipe;


@Service
public class RecipeService {
	
	@Autowired
	RecipeDao recipeDao;
	
	public List<Recipe> listAll() {
		return recipeDao.findAll();
	}
	public void save(Recipe std ) {
		recipeDao.save(std);
	}
	
	public Recipe get(int id) {
		return recipeDao.findById(id).get(id);
	}
	
	public void delte(int id) {
		recipeDao.deleteById(id);
	}
	
	
/**
	
    public ArrayList<Recipe> getAllRecipes() {
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        recipeDao.findAll().forEach(recipe -> recipes.add(recipe));
        return recipes;
    }

    public List<Recipe> getRecipeById(int id) {
        return recipeDao.findRecipeById(id);
    }
    public void saveOrUpdate(Recipe recipe) {
       recipeDao.save(recipe);
    }

    public void deleteRecipeId(int id) {
        recipeDao.deleteById(id);
    }

	public void updateRecipe(Recipe recipe) {
		recipeDao.save(recipe);		
	
	}
*/

}
