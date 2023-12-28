package ru.aston.pizzeria.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Pizza")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private PizzaOrder pizzaOrder;
	
	@ManyToMany(mappedBy = "pizzas")
	private List<Ingredient> ingredients = new ArrayList<>();
	
	public void addIngredient(Ingredient ingredient) {
		ingredients.add(ingredient);
		ingredient.getPizzas().add(null);
	}
}
