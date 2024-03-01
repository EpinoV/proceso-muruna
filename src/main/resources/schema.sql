drop table if exists PHONES;
drop table if exists TOKEN;
drop table if exists USERS;
create table USERS(
  USER_ID int not null AUTO_INCREMENT,
  NAME varchar(100) not null,
  EMAIL varchar(250),
  PASSWORD varchar(100),
  ROLE VARCHAR (100),
  CREATED DATETIME,
  MODIFIED DATETIME,
  LAST_LOGIN DATETIME,
  TOKEN VARCHAR(200),
  ISACTIVE BOOLEAN,
PRIMARY KEY ( USER_ID )
);

create table PHONES(
  PHONE_ID int not null AUTO_INCREMENT,
  USER_ID int not null,
  PHONE_NUMBER varchar(60) not null,
  CITY_CODE varchar(3),
  COUNTRY_CODE varchar(3),
  PRIMARY KEY ( PHONE_ID ),
  FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);

create table TOKEN(
  TOKEN_ID int not null AUTO_INCREMENT,
  USER_ID int not null,
  TOKEN varchar (200) not null,
  TOKEN_TYPE varchar (50) not null,
  REVOKED boolean,
  EXPIRED boolean,
  PRIMARY KEY ( TOKEN_ID ),
  FOREIGN KEY (USER_ID) REFERENCES USERS(USER_ID)
);