create table if not exists ingredients (
  id identity primary key,
  name varchar(150) not null,
  type varchar(150) not null
);

create table if not exists burgers (
  id identity primary key,
  name varchar(50) not null
);

create table if not exists burgers_ingredients (
  burger bigint not null,
  ingredient bigint not null
);
alter table burgers_ingredients
  add foreign key (burger) references burgers(id);
alter table burgers_ingredients
  add foreign key (ingredient) references ingredients(id);

create table if not exists orders (
  id identity primary key,
  createdAt timestamp not null,
  name varchar(50) not null,
  street varchar(50) not null,
  zipcode int not null
);
create table if not exists burgers_orders (
  burgerOrder bigint not null,
  burger bigint not null
);
alter table burgers_orders
  add foreign key (burgerOrder) references orders(id);
alter table burgers_orders
  add foreign key (burger) references burgers(id);