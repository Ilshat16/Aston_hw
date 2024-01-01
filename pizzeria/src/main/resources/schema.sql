create table Pizza_order (
	id Serial primary key,
	customer_name varchar
);

create table Food (
    id Serial primary key,
    bd_type varchar,
    customer_id int references Pizza_order(id),
    food_name varchar,
    size int,
    value int
);

create table Ingredient (
	id Serial primary key,
	ingredient_name varchar
);

create table Ingredients_for_pizza(
	pizza_id int references Food(id),
	ingredient_id int references Ingredient(id)
);

insert into Pizza_order(customer_name) values
	('Jhon'),
	('Tom'),
	('Kate'),
	('Bob'),
	('Lili');

insert into Ingredient(ingredient_name) values
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

insert into Food(bd_type, customer_id, food_name, size, value) values
	('PA', 1, 'Sassuage', 3, null),
	('DK', 1, 'cola' , null , 500),
	('PA', 2, 'Mushrooms', 1, null),
	('DK', 2, 'tea' , null, 200),
	('PA', 1, 'Cheese', 2, null),
	('PA', 3, 'Chiken', 3, null),
	('DK', 3, 'pepsi',  null, 300),
	('PA', 4, 'Pineapple', 1, null),
	('DK', 4, 'coffe', null, 200),
	('PA', 2, 'Cucumber', 2,  null),
	('PA', 3, 'Bacon', 1, null),
	('PA', 5, 'Fish', 3, null),
	('DK', 5, 'water', null, 1000);

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