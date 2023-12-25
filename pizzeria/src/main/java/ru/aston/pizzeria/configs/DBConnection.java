package ru.aston.pizzeria.configs;

import java.awt.Menu;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.aston.pizzeria.models.Ingredient;
import ru.aston.pizzeria.models.Pizza;
import ru.aston.pizzeria.models.PizzaOrder;

public class DBConnection {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().addAnnotatedClass(Menu.class)
				.addAnnotatedClass(Pizza.class)
				.addAnnotatedClass(Ingredient.class)
				.addAnnotatedClass(PizzaOrder.class);
		return configuration.buildSessionFactory();
	}
}
