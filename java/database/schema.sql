BEGIN TRANSACTION;

DROP TABLE IF EXISTS volunteer_application;
DROP TABLE IF EXISTS volunteers CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS administrators CASCADE;
DROP TABLE IF EXISTS adoptions;
DROP TABLE IF EXISTS pets CASCADE;


CREATE TABLE users (
	user_id SERIAL,
	username VARCHAR(50) NOT NULL UNIQUE,
	password_hash VARCHAR(200) NOT NULL,
	role VARCHAR(50) NOT NULL,
    email VARCHAR(255),
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    phone VARCHAR(255),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE volunteers (
	volunteer_id SERIAL,
	user_id INT NOT NULL,
	volunteer_name VARCHAR(32) NOT NULL,
	volunteer_role VARCHAR (64) NOT NULL,

	CONSTRAINT PK_volunteer_id PRIMARY KEY (volunteer_id),
	CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users(user_id)

);

CREATE TABLE administrators (
	administrator_id SERIAL,
	user_id INT NOT NULL,
	role VARCHAR(50) NOT NULL,

	CONSTRAINT PK_administrator_id PRIMARY KEY (administrator_id),
	CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users(user_id)

);

CREATE TABLE volunteer_application (
	application_id SERIAL,
	user_id INT NOT NULL,
	application_status VARCHAR NOT NULL,

	CONSTRAINT PK_application_id PRIMARY KEY (application_id),
	CONSTRAINT FK_users FOREIGN KEY (user_id) REFERENCES users(user_id)

);


CREATE TABLE pets (
	pet_id SERIAL,
	pet_name varchar(50) NOT NULL,
	pet_photo varChar (250),
	is_adopted boolean NOT NULL,
	species varChar(50) NOT NULL,
	gender varChar (32) NOT NULL,
	breed varChar (32) NOT NULL,
	age_years int NOT NULL,
	description varChar (100) NOT NULL,
    adoption_date varchar (255),

	CONSTRAINT PK_pet_id PRIMARY KEY (pet_id)

);

CREATE TABLE adoptions (
	adoption_id SERIAL,
	pet_id INT NOT NULL,
	adoption_date varchar(255),
	parent_name VARCHAR(32) NOT NULL,
	parent_email VARCHAR(32) NOT NULL,

	CONSTRAINT adoption_id PRIMARY KEY (adoption_id),
	CONSTRAINT FK_pets FOREIGN KEY (pet_id) REFERENCES pets(pet_id)
);




COMMIT TRANSACTION;
