package ru.aston.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aston.pizzeria.dao.FoodDAO;
import ru.aston.pizzeria.models.Pizza;

@Controller
@RequestMapping("/pizza")
public class PizzaController {
    private FoodDAO foodDAO;

    @Autowired
    public PizzaController(FoodDAO foodDAO) {
        this.foodDAO = foodDAO;
    }

    @GetMapping("/{name}")
    public String getIngredients(@PathVariable("name") String name, Model model) {
        Pizza pizza = foodDAO.findPizzaByName(name);
        model.addAttribute("pizza", pizza);
        return "pizza";
    }
}
