package ru.aston.pizzeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.aston.pizzeria.models.PizzaOrder;


@Repository
public interface PizzaOrderRepository extends JpaRepository<PizzaOrder, Integer> {
    @Query("SELECT p FROM PizzaOrder p JOIN FETCH p.foods WHERE p.id = :id")
    PizzaOrder getPizzaOrderWithFoods(@Param("id") int id);
}
