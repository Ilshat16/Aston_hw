drop table if exists Ingredients_for_pizza;
drop table if exists Pizza;
drop table if exists Ingredient;
drop table if exists Pizza_order;

create table Pizza_order (
	id Serial primary key,
	customer_name varchar
);

create table Pizza (
    id Serial primary key,
    customer_id int references Pizza_order(id),
    name varchar
);

create table Ingredient (
	id Serial primary key,
	name varchar
);

create table Ingredients_for_pizza(
	pizza_id int references Pizza(id),
	ingredient_id int references Ingredient(id),
	primary key(pizza_id, ingredient_id)
);


	
insert into Pizza_order(customer_name) values
	('Jhon'),
	('Tom'),
	('Kate'),
	('Bob'),
	('Lili');

insert into Ingredient(name) values
	('sassuage'),
	('tomato'),
	('mushrooms'),
	('cheese'),
	('olives'),
	('smoked chiken'),
	('pineapple'),
	('cucumber'),
	('bacon'),
	('fish');

insert into Pizza(customer_id, name) values
	(1, 'Sassuage'),
	(2, 'Mushrooms'),
	(1, 'Cheese'),
	(3, 'Chiken'),
	(4, 'Pineapple'),
	(2, 'Cucumber'),
	(3, 'Bacon'),
	(5, 'Fish');

insert into Ingredients_for_pizza(pizza_id, ingredient_id) values
	(1, 1),
	(1, 2),
	(1, 4),
	(2, 3),
	(2, 4),
	(2, 5),
	(3, 4),
	(3, 5),
	(4, 6),
	(4, 5),
	(4, 4),
	(4, 2),
	(5, 7),
	(5, 1),
	(5, 4),
	(6, 1),
	(6, 4),
	(6, 8),
	(7, 9),
	(7, 4),
	(8, 10),
	(8, 4),
	(8, 2);