create table IF NOT EXISTS ACTOR(
	cod INT IDENTITY,
	name varchar(25),
	yearofbirthdate INT,
	PRIMARY KEY (cod)
);

/*
create table IF NOT EXISTS PELICULA(
	peliculaName varchar(25),
	codActor INT,
	PRIMARY KEY (peliculaName),
	FOREIGN KEY (codactor) REFERENCES OWNER(codActor)
);
*/