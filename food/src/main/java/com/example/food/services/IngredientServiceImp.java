package com.example.food.services;

import com.example.food.model.Ingredient;
import com.example.food.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IngredientServiceImp implements IEIngredientService{
    @Autowired
    IngredientRepository ingredientRepository;

//    public IngredientServiceImp(IngredientRepository ingredientRepository) {
//        this.ingredientRepository = ingredientRepository;
//    }
    @Override
    public Ingredient addIngredient(Ingredient ingredient) {
        if(ingredient!=null){
            ingredientRepository.save(ingredient);
        }
        return null;
    }

    @Override
    public Ingredient updateIngredient(Integer id, Ingredient ingredient) {
        if(ingredient!=null){
            Ingredient ingredient1 = ingredientRepository.getById(id);
            if(ingredient1!=null){
                ingredient1.setName(ingredient.getName());
                ingredient1.setPrice(ingredient.getPrice());
                ingredient1.setCalories(ingredient.getCalories());
                ingredient1.setImage(ingredient.getImage());
                return ingredientRepository.save(ingredient1);
            }
        }
        return null;
    }

    @Override
    public boolean deleteIngredient(Integer id) {
        Ingredient ingredient = ingredientRepository.getById(id);
        if(ingredient!=null){
            ingredientRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Ingredient> showAll() {
        return ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> searchIngredient(String keyword) {
        List<Ingredient> ingredients = ingredientRepository.searchIngredient(keyword);
        return ingredients;
    }


}
