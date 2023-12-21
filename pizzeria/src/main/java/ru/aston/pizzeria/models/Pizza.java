package ru.aston.pizzeria.models;

import java.util.List;

import lombok.Data;

@Data
public class Pizza {
	private int id;
	private String name;
	private List<Ingredient> ingredients;
}
