package ru.aston.pizzeria.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.pizzeria.dao.IngredientAndPizzaJoinDAO;
import ru.aston.pizzeria.dao.IngredientDAO;
import ru.aston.pizzeria.dao.PizzaDAO;
import ru.aston.pizzeria.models.Ingredient;
import ru.aston.pizzeria.models.IngredientAndPizzaJoin;
import ru.aston.pizzeria.models.Pizza;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/ingredient")
public class IngredientServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private IngredientAndPizzaJoinDAO ingredientsDAO;
	private PizzaDAO pizzaDAO;
	private IngredientDAO ingredientDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ingredientDAO = new IngredientDAO();
		ingredientsDAO = new IngredientAndPizzaJoinDAO();
		pizzaDAO = new PizzaDAO();
		
		response.setContentType("text/html");
		PrintWriter printWriter = response.getWriter();
		
		int pizzaId = Integer.parseInt(request.getParameter("id"));
		Pizza pizza = pizzaDAO.findById(pizzaId);
		List<IngredientAndPizzaJoin> ingredientsList = ingredientsDAO.findByPizzaId(pizzaId);
		
		printWriter.write("Ингредиенты пиццы " + pizza.getName() + ":" + "<br/>");
		for (int i = 0; i < ingredientsList.size(); i++) {
			int ingredientId = ingredientsList.get(i).getIngredientId();
			Ingredient ingredient = ingredientDAO.findById(ingredientId);
			printWriter.write((i + 1) + ". " + ingredient.getName() + "<br/>");
		}
		
	}

}
