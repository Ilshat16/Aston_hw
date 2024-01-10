package ru.aston.pizzeria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.aston.pizzeria.models.*;
import ru.aston.pizzeria.repositories.IngredientRepository;
import ru.aston.pizzeria.repositories.PizzaOrderRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pizza_order")
public class PizzaOrderController {

    private final PizzaOrderRepository pizzaOrderRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public PizzaOrderController(PizzaOrderRepository pizzaOrderRepository, IngredientRepository ingredientRepository) {
        this.pizzaOrderRepository = pizzaOrderRepository;
        this.ingredientRepository = ingredientRepository;
    }

    @GetMapping()
    public String getOrderers(Model model) {
        List<PizzaOrder> orderers = pizzaOrderRepository.findAll();
        model.addAttribute("orderers", orderers);
        return "orderers";
    }

    @GetMapping("/{id}")
    public String getOrderer(@PathVariable("id") int id, Model model) {
        PizzaOrder pizzaOrder = pizzaOrderRepository.findById(id).orElse(null);
        model.addAttribute("pizzaOrder", pizzaOrder);
        return "orderer";
    }

    @GetMapping("/{id}/foods")
    public String getFoods(@PathVariable("id") int id, Model model) {
        PizzaOrder pizzaOrder = pizzaOrderRepository.getPizzaOrderWithFoods(id);
        List<Food> foods = new ArrayList<>();
        if (pizzaOrder != null) {
            foods.addAll(pizzaOrder.getFoods());
            model.addAttribute("pizzas", getPizzas(foods));
            model.addAttribute("drinks", getDrinks(foods));
        } else
            pizzaOrder = pizzaOrderRepository.findById(id).orElse(null);

        model.addAttribute("pizzaOrder", pizzaOrder);

        return "foods";
    }

    @GetMapping("/newOrderer")
    public String showNewOrderForm(@ModelAttribute("orderer") PizzaOrder pizzaOrder) {
        return "newOrderer";
    }

    @GetMapping("/{id}/foods/newFood")
    public String chooseFood(@PathVariable("id") int id, Model model) {
        model.addAttribute("id", id);
        return "chooseFood";
    }

    @GetMapping("/{id}/foods/newFood/pizza")
    public String showCreatePizzaForm(@PathVariable("id") int id, Model model,
                                      @ModelAttribute("pizza") Pizza pizza) {
        List<Ingredient> allIngredients = ingredientRepository.findAll();

        model.addAttribute("id", id);
        model.addAttribute("allIngredients", allIngredients);
        return "newPizza";
    }

    @PostMapping("/{id}/foods")
    public String createPizza(@PathVariable("id") int id,
                              @ModelAttribute("pizza") Pizza pizza) {
        PizzaOrder pizzaOrder = pizzaOrderRepository.findById(id).orElse(null);
        pizzaOrder.addFood(pizza);
        pizza.setPizzaOrder(pizzaOrder);
        pizzaOrderRepository.save(pizzaOrder);
        return "redirect:/pizza_order/" + id + "/foods";
    }

    @PostMapping
    public String saveNewOrder(@ModelAttribute("orderer") PizzaOrder pizzaOrder) {
        pizzaOrderRepository.save(pizzaOrder);
        System.out.println(pizzaOrder.getCustomerName());
        return "redirect:/pizza_order";
    }

    @PostMapping("/{id}")
    public String deleteOrder(@PathVariable("id") int id) {
        pizzaOrderRepository.deleteById(id);
        return "redirect:/pizza_order";
    }

    private List<Pizza> getPizzas(List<Food> foods) {
        List <Pizza> pizzas = new ArrayList<>();
        for(Food food : foods) {
            if(food instanceof Pizza)
                pizzas.add((Pizza) food);
        }
        return pizzas;
    }

    private List<Drink> getDrinks(List<Food> foods) {
        List<Drink> drinks = new ArrayList<>();
        for (Food food : foods) {
            if (food instanceof Drink)
                drinks.add((Drink) food);
        }
        return drinks;
    }
}
