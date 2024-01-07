package ru.aston.pizzeria.servlets;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.pizzeria.dao.FoodDAO;
import ru.aston.pizzeria.dao.PizzaOrderDAO;
import ru.aston.pizzeria.models.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/pizza")
public class PizzaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FoodDAO foodDAO = new FoodDAO();
		PizzaOrderDAO pizzaOrderDAO = new PizzaOrderDAO();
		
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		int customerId = Integer.parseInt(request.getParameter("id"));
		PizzaOrder pizzaOrder = pizzaOrderDAO.findById(customerId);
		List<Pizza> pizzas = foodDAO.getPizzaWithIngredients(pizzaOrder);
		List<Drink> drinks = foodDAO.getDrink(pizzaOrder);

		for (Drink drink : drinks)
			printWriter.write("Напиток " + drink.getName() + "<br/>");
		for (Pizza pizza : pizzas) {
			List<Ingredient> ingredients = pizza.getIngredients();
			printWriter.write("Ингредиенты пиццы " + pizza.getName() + ":" + "<br/>");
			for (int i = 0; i < ingredients.size(); i++) {
				Ingredient ingredient = ingredients.get(i);
				printWriter.write((i + 1) + ". " + ingredient.getName() + "<br/>");
			}
			printWriter.write("<br/>");
		}
		printWriter.close();
	}
}
