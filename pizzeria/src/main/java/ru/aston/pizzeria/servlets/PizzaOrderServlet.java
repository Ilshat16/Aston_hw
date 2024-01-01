package ru.aston.pizzeria.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.aston.pizzeria.dao.PizzaOrderDAO;
import ru.aston.pizzeria.models.Drink;
import ru.aston.pizzeria.models.Food;
import ru.aston.pizzeria.models.Pizza;
import ru.aston.pizzeria.models.PizzaOrder;

@WebServlet("/order")
public class PizzaOrderServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private PizzaOrderDAO pizzaOrderDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pizzaOrderDAO = new PizzaOrderDAO();
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		int foodId = Integer.parseInt(req.getParameter("id"));
		
		PizzaOrder pizzaOrder = pizzaOrderDAO.getPizzaOrderWithFoods(foodId);
		List<Food> foods = pizzaOrder.getFoods();
		
		printWriter.write("Еда заказчика " + pizzaOrder.getCustomerName() + ":" + "<br/>");
		for (int i = 0; i < foods.size(); i++) {
			printWriter.write((i + 1)+ ". " + foods.get(i).getName() + "<br/>");
		}
		printWriter.close();
	}
}
