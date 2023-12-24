package ru.aston.pizzeria.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import jakarta.persistence.Query;
import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.IngredientAndPizzaJoin;

public class IngredientAndPizzaJoinDAO {
	private SessionFactory sessionFactory = DBConnection.getSessionFactory();
	
	public List<IngredientAndPizzaJoin> findByPizzaId(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		Query query = session.createQuery(
				"from IngredientAndPizzaJoin where pizzaId =: id",
				IngredientAndPizzaJoinDAO.class);
		query.setParameter("id", id);
		List<IngredientAndPizzaJoin> ingredients = query.getResultList();
		session.getTransaction().commit();
		
		return ingredients;
	}
	
}
