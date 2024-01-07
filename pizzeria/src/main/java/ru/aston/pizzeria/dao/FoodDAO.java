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
	
	public Pizza findPizzaByName(String name) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		String hql = "from Pizza p JOIN FETCH p.ingredients where p.name =: name";
		Query query = session.createQuery(hql, Pizza.class).setParameter("name", name);
		List<Pizza> resultList = query.getResultList();
		Pizza pizza = resultList.get(0);
		session.getTransaction().commit();

		session.close();
		return pizza;
	}

	public Drink findDrinkByName(String name) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		String hql = "from Drink d where d.name =: name";
		Query query = session.createQuery(hql, Drink.class).setParameter("name", name);
		List<Drink> resultList = query.getResultList();
		Drink drink = resultList.get(0);
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

	public void savePizza(Pizza pizza) {
		Session session = sessionFactory.getCurrentSession();

		session.beginTransaction();
		session.persist(pizza);
		session.getTransaction().commit();

		session.close();
	}
}
