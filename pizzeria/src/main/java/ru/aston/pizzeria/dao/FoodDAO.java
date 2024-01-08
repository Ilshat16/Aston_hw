package ru.aston.pizzeria.dao;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pizzeria.models.*;
import ru.aston.pizzeria.repositories.FoodRepository;

@Service
@Transactional
public class FoodDAO {
	private FoodRepository foodRepository;

	public FoodDAO(FoodRepository foodRepository) {
		this.foodRepository = foodRepository;
	}

	public Pizza findPizzaByNameWithIngredients(String name) {
		return foodRepository.findPizzaByNameWithIngredients(name);
	}

	public void saveFood(Food food) {

	}
}
