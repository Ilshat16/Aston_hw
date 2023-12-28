package ru.aston.pizzeria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.Query;
import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Ingredient;
import ru.aston.pizzeria.models.Pizza;

public class PizzaDAO {
	private SessionFactory sessionFactory = DBConnection.getInstance().getSessionFactory();
	
	public Pizza findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Pizza pizza = session.get(Pizza.class, id);
		session.getTransaction().commit();
		
		return pizza;
	}
	
	public List<Pizza> findAll() {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		List<Pizza> pizzaList = session
				.createQuery("from Pizza", Pizza.class)
				.getResultList();
		session.getTransaction().commit();
		
		return pizzaList;
	}
	
	public List<Ingredient> getIngredients(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		String hql = "SELECT p FROM Pizza p JOIN FETCH p.ingredients WHERE p.id = :id";
		Query query = session.createQuery(hql, Pizza.class).setParameter("id", id);
		List<Pizza> pizza = query.getResultList();
		List<Ingredient> ingredients = pizza.get(0).getIngredients();
		session.getTransaction().commit();
		
		return ingredients;
	}
}
