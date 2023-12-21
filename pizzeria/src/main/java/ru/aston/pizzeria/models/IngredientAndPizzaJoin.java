package ru.aston.pizzeria.models;

import lombok.Data;

@Data
public class IngredientAndPizzaJoin {
	private int pizzaId;
	private int ingredientId;
}
