drop table if exists Pizza;
drop table if exists Ingredient;
drop table if exists Ingredients_for_pizza;

create table Pizza (
    id Serial,
    name varchar
);

create table Ingredient (
	id Serial,
	name varchar
);

create table Ingredients_for_pizza(
	pizza_id int,
	ingredient_id int
);

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

insert into Pizza(name) values
	('Sassuage'),
	('Mushrooms'),
	('Cheese'),
	('Chiken'),
	('Pineapple'),
	('Cucumber'),
	('Bacon'),
	('Fish');

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