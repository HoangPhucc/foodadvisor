package com.example.food.repositories;

import com.example.food.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    @Query("SELECT p FROM Ingredient p WHERE CONCAT(p.name, p.id, p.calories, p.price) LIKE %?1%")
    public List<Ingredient> searchIngredient(String keyword);
}