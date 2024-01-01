package ru.aston.pizzeria;

import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.aston.pizzeria.configs.DBConnection;
import ru.aston.pizzeria.models.Drink;
import ru.aston.pizzeria.models.Food;
import ru.aston.pizzeria.models.Pizza;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory = DBConnection.getInstance().getSessionFactory();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String hql = "FROM Drink as d WHERE d.pizzaOrder.id = :id";
        Query query = session.createQuery(hql, Drink.class).setParameter("id", 2);
        List<Drink> pizzas = query.getResultList();
        for (int i = 0; i < pizzas.size(); i++) {
            System.out.println(pizzas.get(i).getName());
        }
        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
    }
}
