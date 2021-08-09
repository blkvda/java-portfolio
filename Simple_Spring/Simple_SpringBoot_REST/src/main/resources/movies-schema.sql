create table if not exists movies (
  id identity primary key,
  name varchar(150) not null,
  year int not null
);
