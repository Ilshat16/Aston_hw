package ru.aston.pizzeria.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.aston.pizzeria.dao.PizzaDAO;

@WebServlet("/pizza")
public class PizzaServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private PizzaDAO pizzaDAO;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		pizzaDAO = new PizzaDAO();
		resp.setContentType("text/html");
		int id = Integer.parseInt(req.getParameter("id"));
		PrintWriter printWriter = resp.getWriter();
		String pizzaName = pizzaDAO.findById(id).getName();
		printWriter.write("I like pizza - " + pizzaName);
		printWriter.close();
	}

}
