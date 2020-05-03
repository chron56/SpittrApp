use spitterdb;
#SET FOREIGN_KEY_CHECKS = 0;
#truncate table spittles;
#truncate table spitters;
#drop table spitters;
#drop table spittles;
#SET FOREIGN_KEY_CHECKS = 1;
CREATE TABLE spitters ( ID int NOT NULL AUTO_INCREMENT, Username varchar(255) NOT NULL, PRIMARY KEY (ID) );
CREATE TABLE spittles ( ID int NOT NULL AUTO_INCREMENT, SpitterID int NOT NULL, TextValue varchar(255) NOT NULL, PRIMARY KEY (ID), FOREIGN KEY (SpitterID) REFERENCES spitters(ID) );
show tables;


