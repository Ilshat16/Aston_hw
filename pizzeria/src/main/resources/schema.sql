drop table if exists Pizza;
drop table if exists Ingredient;
drop table if exists Ingredients_for_pizza;
drop table if exists Menu;

create table Menu (
	id Serial primary key,
	name varchar
);

create table Pizza (
    id Serial primary key,
    menu_id int references Menu(id),
    name varchar
);

create table Ingredient (
	id Serial primary key,
	name varchar
);

create table Ingredients_for_pizza(
	id Serial primary key,
	pizza_id int references Pizza(id),
	ingredient_id int references Ingredient(id)
);


	
insert into Menu(name) values
	('Pizza'),
	('Dinkes'),
	('Desserts');

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

insert into Pizza(menu_id, name) values
	('1', 'Sassuage'),
	('1', 'Mushrooms'),
	('1', 'Cheese'),
	('1', 'Chiken'),
	('1', 'Pineapple'),
	('1', 'Cucumber'),
	('1', 'Bacon'),
	('1', 'Fish');

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