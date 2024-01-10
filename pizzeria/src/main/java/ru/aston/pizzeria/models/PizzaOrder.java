package ru.aston.pizzeria.models;

import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Pizza_order")
public class PizzaOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pizza_order_seq")
	@SequenceGenerator(name = "pizza_order_seq", sequenceName = "pizza_order_id_seq", allocationSize = 1)
	@Column(name = "id")
	private int id;
	
	@Column(name = "customer_name")
	private String customerName;
	
	@OneToMany(mappedBy = "pizzaOrder")
	private List<Food> foods;

	public void addFood(Food food) {
		this.foods.add(food);
	}

}
