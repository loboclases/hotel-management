create table hotel( id SERIAL PRIMARY KEY, stars number, description VARCHAR (500),name VARCHAR (50),avg_valuation real,location VARCHAR (500));
create table valuation( id SERIAL PRIMARY KEY, "value" real, comment VARCHAR (500),author_id number, hotel_id number,status varchar(50));