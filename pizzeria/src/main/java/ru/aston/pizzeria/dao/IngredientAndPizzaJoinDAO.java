package ru.aston.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.IngredientAndPizzaJoin;

public class IngredientAndPizzaJoinDAO {
	private Connection connection = DBConnection.getConnection();
	
	public List<IngredientAndPizzaJoin> findByPizzaId(int id) {
		List<IngredientAndPizzaJoin> ingredientsList = new ArrayList<>();
		
		try {
			String query = "SELECT name FROM Ingredients_for_pizza WHERE id=?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				IngredientAndPizzaJoin ingredientAndPizzaJoin = new IngredientAndPizzaJoin();
				ingredientAndPizzaJoin.setPizzaId(id);
				ingredientAndPizzaJoin.setIngredientId(Integer.parseInt(rs.getString("ingredient_id")));
				
				ingredientsList.add(ingredientAndPizzaJoin);
			}
			
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ingredientsList;
	}
	
}
