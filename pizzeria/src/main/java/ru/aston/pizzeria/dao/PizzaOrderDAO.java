package ru.aston.pizzeria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import jakarta.persistence.Query;
import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Pizza;
import ru.aston.pizzeria.models.PizzaOrder;

public class PizzaOrderDAO {
	private SessionFactory sessionFactory = DBConnection.getInstance().getSessionFactory();
	
	public PizzaOrder findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		PizzaOrder pizzaOrder = session.get(PizzaOrder.class, id);
		session.getTransaction().commit();
		
		return pizzaOrder;
	}
	
	public List<PizzaOrder> findAll() {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		List<PizzaOrder> orders = session.createQuery("FROM PizzaOrder", PizzaOrder.class).getResultList();
		session.getTransaction().commit();
		return orders;
	}
	
	public List<Pizza> getPizzas(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		String hql = "SELECT p FROM PizzaOrder p JOIN FETCH p.pizzas WHERE p.id = :id";
		Query query = session.createQuery(hql, PizzaOrder.class).setParameter("id", id);
		List<PizzaOrder> orders = query.getResultList();
		List<Pizza> pizzas = orders.get(0).getPizzas();
		session.getTransaction().commit();
		
		return pizzas;
	}

}
