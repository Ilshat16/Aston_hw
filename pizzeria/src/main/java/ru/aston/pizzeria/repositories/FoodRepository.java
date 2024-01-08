package ru.aston.pizzeria.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.aston.pizzeria.models.Food;
import ru.aston.pizzeria.models.Pizza;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

    @Query("select p from Pizza p JOIN FETCH p.ingredients where p.name = :name")
    Pizza findPizzaByNameWithIngredients(@Param("name") String name);
}
