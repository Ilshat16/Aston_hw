package ru.aston.pizzeria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name = "Food")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "bd_type")
public abstract class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id")
	private int id;

	@Column(name = "food_name")
	private String name;
	@ManyToOne
	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	private PizzaOrder pizzaOrder;
}
