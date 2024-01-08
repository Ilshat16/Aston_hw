package ru.aston.pizzeria.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.aston.pizzeria.models.PizzaOrder;
import ru.aston.pizzeria.repositories.PizzaOrderRepository;

@Service
@Transactional
public class PizzaOrderDAO{
	private final PizzaOrderRepository pizzaOrderRepository;

	@Autowired
	public PizzaOrderDAO(PizzaOrderRepository pizzaOrderRepository) {
		this.pizzaOrderRepository = pizzaOrderRepository;
	}

	public PizzaOrder findById(int id) {
		return pizzaOrderRepository.findById(id).orElse(null);
	}
	
	public List<PizzaOrder> findAll() {
		return pizzaOrderRepository.findAll();
	}

	public PizzaOrder getPizzaOrderWithFoods(int id) {
		return pizzaOrderRepository.getPizzaOrderWithFoods(id);
	}

	public void saveOrder(PizzaOrder pizzaOrder) {

	}

}
