package ru.aston.pizzeria.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.aston.pizzeria.dao.PizzaDAO;
import ru.aston.pizzeria.dao.PizzaOrderDAO;
import ru.aston.pizzeria.models.Pizza;
import ru.aston.pizzeria.models.PizzaOrder;

@WebServlet("/pizza_order")
public class PizzaOrdersServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private PizzaOrderDAO pizzaOrderDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pizzaOrderDAO = new PizzaOrderDAO();
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.write("Перечень доступных пицц:" + "<br/>");
		List<PizzaOrder> pizzaOrderList = pizzaOrderDAO.findAll();
		for (int i = 0; i < pizzaOrderList.size(); i++) {
			printWriter.write((i + 1)+ ". " + pizzaOrderList.get(i).getCustomerName() + "<br/>");
		}
		printWriter.close();
	}
}
