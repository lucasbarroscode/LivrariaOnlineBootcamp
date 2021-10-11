create table autores(
id bigint not null auto_increment,
nome varchar(100) not null,
email varchar(100) not null,
data date not null,
miniCV varchar(100) not null,
primary key(id)

);