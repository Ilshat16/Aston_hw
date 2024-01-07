package ru.aston.pizzeria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import jakarta.persistence.Query;
import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Food;
import ru.aston.pizzeria.models.PizzaOrder;

public class PizzaOrderDAO {
	private SessionFactory sessionFactory = DBConnection.getInstance().getSessionFactory();
	
	public PizzaOrder findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		PizzaOrder pizzaOrder = session.get(PizzaOrder.class, id);
		session.getTransaction().commit();

		session.close();
		return pizzaOrder;
	}
	
	public List<PizzaOrder> findAll() {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		List<PizzaOrder> orders = session.createQuery("FROM PizzaOrder", PizzaOrder.class).getResultList();
		session.getTransaction().commit();

		session.close();
		return orders;
	}
	
	public PizzaOrder getPizzaOrderWithFoods(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		String hql = "FROM PizzaOrder p JOIN FETCH p.foods WHERE p.id = :id";
		Query query = session.createQuery(hql, PizzaOrder.class).setParameter("id", id);
		List<PizzaOrder> pizzaOrders = query.getResultList();
		PizzaOrder pizzaOrder = pizzaOrders.get(0);
		session.getTransaction().commit();

		session.close();
		return pizzaOrder;
	}

	public void saveOrder(PizzaOrder pizzaOrder) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.persist(pizzaOrder);
		session.getTransaction().commit();

		session.close();
	}

}
