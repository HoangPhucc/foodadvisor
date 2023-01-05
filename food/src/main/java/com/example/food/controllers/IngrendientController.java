package com.example.food.controllers;


import com.example.food.model.Ingredient;
import com.example.food.services.IEIngredientService;
import com.example.food.services.IngredientServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
public class IngrendientController {
    @Autowired
    IngredientServiceImp ingredientServiceImp;

    @GetMapping("/")
    public String homePage(){
        return "hello";
    }

    // add
    @PostMapping("/insert")
    public Ingredient addIngredient(@RequestBody Ingredient ingredient){

        return ingredientServiceImp.addIngredient(ingredient);
    }

    // update
    @PutMapping("update")
    public Ingredient updateIngredient(@RequestParam("id") Integer id,@RequestBody Ingredient ingredient){
        return ingredientServiceImp.updateIngredient(id,ingredient);
    }

    // delete
    @DeleteMapping("/delete/{id}")
    public boolean deleteIngredient(@PathVariable("id") Integer id){
        return ingredientServiceImp.deleteIngredient(id);
    }

    // danh sách
    @GetMapping("/list")
    public List<Ingredient> getAllIngredient(){
        return ingredientServiceImp.showAll();
    }

//    @GetMapping("/search")
//    public Ingredient Search(@RequestParam("keyword") String keyword) {
//        List<Ingredient> ingredient = ingredientServiceImp.searchIngredient(keyword);
//
//        return ingredient;
//    }

//    public IngrendientController(IngredientServiceImp ingredientServiceImp) {
//        this.ingredientServiceImp = ingredientServiceImp;
//    }

    @GetMapping("/search")
    public ResponseEntity<List<Ingredient>> searchIngredient(@RequestParam("keyword") String keyword){
        return ResponseEntity.ok(ingredientServiceImp.searchIngredient(keyword));
    }
}
