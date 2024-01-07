package ru.aston.pizzeria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.Query;
import org.springframework.stereotype.Service;
import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.*;

@Service
public class FoodDAO {
	private SessionFactory sessionFactory = DBConnection.getInstance().getSessionFactory();
	
	public Pizza findPizzaById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Pizza pizza = session.get(Pizza.class, id);
		session.getTransaction().commit();

		session.close();
		return pizza;
	}

	public Drink findDrinkById(int id) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		Drink drink = session.get(Drink.class, id);
		session.getTransaction().commit();

		session.close();
		return drink;
	}
	
	public List<Pizza> findAllPizza() {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		List<Pizza> pizzaList = session
				.createQuery("from Pizza", Pizza.class)
				.getResultList();
		session.getTransaction().commit();

		session.close();
		return pizzaList;
	}

	public List<Drink> findAllDrink() {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		List<Drink> drinkList = session
				.createQuery("from Drink", Drink.class)
				.getResultList();
		session.getTransaction().commit();

		session.close();
		return drinkList;
	}
	
	public List<Pizza> getPizzaWithIngredients(PizzaOrder pizzaOrder) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		String hql = "FROM Pizza p JOIN FETCH p.ingredients WHERE p.pizzaOrder = :pizzaOrder";
		Query query = session.createQuery(hql, Pizza.class).setParameter("pizzaOrder", pizzaOrder);
		List<Pizza> pizzas = query.getResultList();
		session.getTransaction().commit();

		session.close();
		return pizzas;
	}

	public List<Drink> getDrink(PizzaOrder pizzaOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();

		String hql = "from Drink d where d.pizzaOrder = :pizzaOrder";
		Query query = session.createQuery(hql, Drink.class).setParameter("pizzaOrder", pizzaOrder);
		List<Drink> drinks = query.getResultList();

		session.getTransaction().commit();
		session.close();
		return drinks;
	}

	public void savePizza(Pizza pizza) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.persist(pizza);
		session.getTransaction().commit();

		session.close();
	}
}
