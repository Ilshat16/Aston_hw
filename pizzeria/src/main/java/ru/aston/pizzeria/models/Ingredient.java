package ru.aston.pizzeria.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ingredient_name")
	private String name;
	
	@ManyToMany
	@JoinTable(
			name = "Ingredients_for_pizza",
			joinColumns = @JoinColumn(name = "ingredient_id"),
			inverseJoinColumns = @JoinColumn(name = "pizza_id")
			)
	private List<Pizza> pizzas;
	
	public void addPizza(Pizza pizza) {
		pizzas.add(pizza);
		pizza.getIngredients().add(this);
	}
}
