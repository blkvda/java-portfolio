delete from burgers_orders;
delete from orders;
delete from burgers_ingredients;
delete from burgers;
delete from ingredients;

insert into ingredients (name, type)
values ('Ketchup', 'SAUCE');
insert into ingredients (name, type)
values ('Mayonnaise', 'SAUCE');
insert into ingredients (name, type)
values ('Cheddar', 'CHEESE');
insert into ingredients (name, type)
values ('Parmesan', 'CHEESE');
insert into ingredients (name, type)
values ('Tomato', 'VEGGIES');
insert into ingredients (name, type)
values ('Pickle', 'VEGGIES');
insert into ingredients (name, type)
values ('Beef', 'PROTEIN');
insert into ingredients (name, type)
values ('Pork', 'PROTEIN');
insert into ingredients (name, type)
values ('Chicken', 'PROTEIN');
insert into ingredients (name, type)
values ('Shrimp', 'PROTEIN');