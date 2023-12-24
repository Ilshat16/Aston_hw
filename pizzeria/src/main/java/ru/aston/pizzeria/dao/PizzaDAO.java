package ru.aston.pizzeria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Pizza;

public class PizzaDAO {
	private SessionFactory sessionFactory = DBConnection.getSessionFactory();
	
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
}
