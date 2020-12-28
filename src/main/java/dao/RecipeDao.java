package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import entity.Recipe;

@Repository
public interface RecipeDao extends JpaRepository<Recipe, Integer> {
	List<Recipe> findById(int id);

}
