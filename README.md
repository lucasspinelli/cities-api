# Cities API

## Requirements

* Linux - if you use Windows, use [WSL 2](https://docs.microsoft.com/en-us/windows/wsl/install)
* Git
* Java 8
* Docker
* IntelliJ Community
* Heroku CLI

## DataBase

### Postgres

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)

```shell script
docker run --name cities-db -d -p 5432:5432 -e POSTGRES_USER=postgres_user_city -e POSTGRES_PASSWORD=super_password -e POSTGRES_DB=cities postgres
```

### Populate

* [Cities](https://github.com/chinnonsantos/sql-paises-estados-cidades/tree/master/PostgreSQL)

```shell script
cd ~/workspace/sql-paises-estados-cidades/PostgreSQL
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash
psql -h localhost -U postgres_user_city cities -f /tmp/pais.sql
psql -h localhost -U postgres_user_city cities -f /tmp/estado.sql
psql -h localhost -U postgres_user_city cities -f /tmp/cidade.sql
psql -h localhost -U postgres_user_city cities
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)


### How to Use

* /distance/by-cube?from={city-id}&to={city-id} - to show the distance in meters 
* /distance/by-point?from={city-id}&to={city-id} - to show the distance in miles 
* /cities - to display every city in database, paged 20 by 20 - /cities?page={int} to change page
* /states - to display every states in database
* /countries - to display every country
* You can test by free for a limited time only (until free access on Heroku lasts) [here](https://ancient-island-19690.herokuapp.com/cities)
