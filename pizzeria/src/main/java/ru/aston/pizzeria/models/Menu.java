package ru.aston.pizzeria.models;

import java.util.List;

import lombok.Data;

@Data
public class Menu {
	private List<Pizza> pizza;
}
