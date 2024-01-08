package ru.aston.pizzeria.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.aston.pizzeria.models.Ingredient;
import ru.aston.pizzeria.repositories.IngredientRepository;

@Service
@Transactional
public class IngredientDAO {
	private IngredientRepository ingredientRepository;

	@Autowired
	public IngredientDAO(IngredientRepository ingredientRepository) {
		this.ingredientRepository = ingredientRepository;
	}

	public Ingredient findById(int id) {
		return ingredientRepository.findById(id).orElse(null);
	}
	
	public List<Ingredient> findAll() {
		return ingredientRepository.findAll();
	}
	
}
