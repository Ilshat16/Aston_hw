package ru.aston.pizzeria.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("PA")
public class Pizza extends Food{

	@Column(name = "size")
	private int size;
	
	@ManyToMany(mappedBy = "pizzas")
	private List<Ingredient> ingredients = new ArrayList<>();
}
