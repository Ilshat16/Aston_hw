package ru.aston.pizzeria.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Food")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bd_type")
public abstract class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "food_seq", sequenceName = "food_id_seq", allocationSize = 1)
	@Column(name = "id")
	protected int id;

	@Column(name = "food_name")
	protected String name;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	protected PizzaOrder pizzaOrder;
}
