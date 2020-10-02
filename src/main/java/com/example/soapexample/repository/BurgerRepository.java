package com.example.soapexample.repository;

import com.example.soapexample.webservice.gen.Burger;
import com.example.soapexample.webservice.gen.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BurgerRepository {

    private List<Burger> burgers;

    public BurgerRepository() {
        this.burgers = new ArrayList<>();
        addBurger1();
        addBurger2();
    }

    public Burger getBurgerById(long id) {
        return this.burgers
                .stream()
                .filter(burger -> burger.getId() == id)
                .findFirst()
                .get();
    }

    private void addBurger1() {
        Burger burger1 = new Burger();
        burger1.setId(1);
        burger1.setName("Burger1");
        Burger.Ingredients burger1IngredientsElement = new Burger.Ingredients();
        List<Ingredient> burger1Ingredients = burger1IngredientsElement.getIngredient();
        Ingredient burger1Ingredient1 = new Ingredient();
        burger1Ingredient1.setId(1);
        burger1Ingredient1.setName("Ingredient1");
        burger1Ingredients.add(burger1Ingredient1);
        Ingredient burger1Ingredient2 = new Ingredient();
        burger1Ingredient2.setId(2);
        burger1Ingredient2.setName("Ingredient2");
        burger1Ingredients.add(burger1Ingredient2);
        burger1.setIngredients(burger1IngredientsElement);
        this.burgers.add(burger1);
    }

    private void addBurger2() {
        Burger burger2 = new Burger();
        burger2.setId(2);
        burger2.setName("Burger2");
        Burger.Ingredients burger2IngredientsElement = new Burger.Ingredients();
        List<Ingredient> burger2Ingredients = burger2IngredientsElement.getIngredient();
        Ingredient burger2Ingredient1 = new Ingredient();
        burger2Ingredient1.setId(1);
        burger2Ingredient1.setName("Ingredient1");
        burger2Ingredients.add(burger2Ingredient1);
        Ingredient burger2Ingredient2 = new Ingredient();
        burger2Ingredient2.setId(2);
        burger2Ingredient2.setName("Ingredient2");
        burger2Ingredients.add(burger2Ingredient2);
        burger2.setIngredients(burger2IngredientsElement);
        this.burgers.add(burger2);
    }
}
