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
		int pizzaId = Integer.parseInt(req.getParameter("id"));
		
		PizzaOrder pizzaOrder = pizzaOrderDAO.findById(pizzaId);
		List<Pizza> pizzas = pizzaOrderDAO.getPizzas(pizzaId);
		
		printWriter.write("Пиццы заказчика " + pizzaOrder.getCustomerName() + ":" + "<br/>");
		for (int i = 0; i < pizzas.size(); i++) {
			printWriter.write((i + 1)+ ". " + pizzas.get(i).getName() + "<br/>");
		}
			
		printWriter.close();
	}

}
