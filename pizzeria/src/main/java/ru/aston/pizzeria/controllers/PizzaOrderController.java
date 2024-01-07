package ru.aston.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.aston.pizzeria.dao.PizzaOrderDAO;
import ru.aston.pizzeria.models.Food;
import ru.aston.pizzeria.models.PizzaOrder;

import java.util.List;

@Controller
@RequestMapping("/pizza_order")
public class PizzaOrderController {

    private PizzaOrderDAO pizzaOrderDAO;

    @Autowired
    public PizzaOrderController(PizzaOrderDAO pizzaOrderDAO) {
        this.pizzaOrderDAO = pizzaOrderDAO;
    }

    @GetMapping()
    public String getOrderers(Model model) {
        List<PizzaOrder> orderers = pizzaOrderDAO.findAll();
        model.addAttribute("orderers", orderers);
        return "orderers";
    }

    @GetMapping("/{id}")
    public String getFoods(@PathVariable("id") int id, Model model) {
        PizzaOrder pizzaOrder = pizzaOrderDAO.getPizzaOrderWithFoods(id);
        List<Food> foods = pizzaOrder.getFoods();
        model.addAttribute("foods", foods);
        return  "foods";
    }
}
