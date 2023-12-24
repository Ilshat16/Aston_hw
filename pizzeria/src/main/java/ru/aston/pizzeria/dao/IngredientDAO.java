package ru.aston.pizzeria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Ingredient;

public class IngredientDAO {
	private SessionFactory sessionFactory = DBConnection.getSessionFactory();
	
	public Ingredient findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Ingredient ingredient = session.get(Ingredient.class, id);
		session.getTransaction().commit();
		
		return ingredient;
	}
	
	public List<Ingredient> findAll() {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		List<Ingredient> ingredientList = session
				.createQuery("from Ingredient", Ingredient.class)
				.getResultList();
		session.getTransaction().commit();
		
		return ingredientList;
	}
	
}
