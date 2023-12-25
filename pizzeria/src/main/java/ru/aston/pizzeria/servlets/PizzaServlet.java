package ru.aston.pizzeria.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.pizzeria.dao.PizzaDAO;
import ru.aston.pizzeria.models.Ingredient;
import ru.aston.pizzeria.models.Pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/pizza")
public class PizzaServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private PizzaDAO pizzaDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		pizzaDAO = new PizzaDAO();
		
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		int pizzaId = Integer.parseInt(request.getParameter("id"));
		Pizza pizza = pizzaDAO.findById(pizzaId);
		List<Ingredient> ingredients = pizzaDAO.getIngredients(pizzaId);
		
		printWriter.write("Ингредиенты пиццы " + pizza.getName() + ":" + "<br/>");
		for (int i = 0; i < ingredients.size(); i++) {
			Ingredient ingredient = ingredients.get(i);
			printWriter.write((i + 1) + ". " + ingredient.getName() + "<br/>");
		}
		
	}

}
