package ru.aston.pizzeria.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Ingredient")
public class Ingredient {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ingredient_seq", sequenceName = "ingredient_id_seq", allocationSize = 1)
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
