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
import ru.aston.pizzeria.models.Pizza;

@WebServlet("/pizza")
public class PizzaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private PizzaDAO pizzaDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pizzaDAO = new PizzaDAO();
		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		List<Pizza> pizzaList = pizzaDAO.findAll();
		for (int i = 0; i < pizzaList.size(); i++) {
			printWriter.write((i + 1)+ ". " + pizzaList.get(i).getName() + "<br/>");
		}
			
		printWriter.close();
	}

}
