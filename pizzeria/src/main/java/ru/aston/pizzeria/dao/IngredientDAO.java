package ru.aston.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Ingredient;

public class IngredientDAO {
	private Connection connection = DBConnection.getConnection();
	
	public Ingredient findById(int id) {
		Ingredient ingredient = null;
		try {
			String query = "SELECT name FROM Ingredient WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			
			ingredient = new Ingredient();
			ingredient.setId(id);
			ingredient.setName(rs.getString("name"));
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredient;
	}
	
	public List<Ingredient> findAll() {
		List<Ingredient> ingredientList = new ArrayList<>();
		try {
			Statement statement = connection.createStatement();
			String query = "SELECT name FROM Ingredient";
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Ingredient ingredient = new Ingredient();
				ingredient.setId(rs.getInt("id"));
				ingredient.setName(rs.getString("name"));
				ingredientList.add(ingredient);
			}
			
			rs.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredientList;
	}
	
}
