package ru.aston.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Pizza;

public class PizzaDAO {
	private Connection connection = DBConnection.getConnection();
	
	public Pizza findById(int id) {
		Pizza pizza = null;
		try {
			String query = "SELECT name FROM Pizza WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			pizza = new Pizza();
			pizza.setId(id);
			pizza.setName(rs.getString("name"));
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pizza;
	}
	
	public List<Pizza> findAll() {
		List<Pizza> pizzaList = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT name FROM Pizza";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Pizza pizza = new Pizza();
				pizza.setId(rs.getInt("id"));
				pizza.setName(rs.getString("name"));
				pizzaList.add(pizza);
			}
			
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return pizzaList;
	}
}
