package com.example.food.services;

import com.example.food.model.Ingredient;

import java.util.List;

public interface IEIngredientService {
    // add Ingredient
    public Ingredient addIngredient(Ingredient ingredient);
    // update
    public Ingredient updateIngredient(Integer id, Ingredient ingredient);
    // delete
    public boolean deleteIngredient(Integer id);
    //show
    public List<Ingredient> showAll();
    // search theo id
    public List<Ingredient> searchIngredient(String keyword);


}
