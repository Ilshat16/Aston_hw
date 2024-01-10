package ru.aston.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aston.pizzeria.models.Ingredient;
import ru.aston.pizzeria.models.Pizza;
import ru.aston.pizzeria.repositories.FoodRepository;
import ru.aston.pizzeria.repositories.IngredientRepository;
import ru.aston.pizzeria.repositories.PizzaOrderRepository;

import java.util.List;

@Controller
@RequestMapping("/food")
public class FoodController {
    private FoodRepository foodRepository;

    @Autowired
    public FoodController(FoodRepository foodfoodRepository) {
        this.foodRepository = foodfoodRepository;
    }

    @GetMapping("/{name}")
    public String getIngredients(@PathVariable("name") String name, Model model) {
        Pizza pizza = foodRepository.findPizzaByNameWithIngredients(name);
        model.addAttribute("pizza", pizza);
        return "pizza";
    }

}
