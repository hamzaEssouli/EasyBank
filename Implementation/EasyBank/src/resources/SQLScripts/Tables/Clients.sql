CREATE TABLE Clients (
	id SERIAL NOT NULL UNIQUE,
	employeeId int NOT NULL,
	lastName VARCHAR(30) NOT NULL,
	firstName VARCHAR(30) NOT NULL,
	dateOfBirth DATE NOT NULL,
	phoneNumber VARCHAR(15) NOT NULL UNIQUE,
	address VARCHAR(255) NOT NULL,
	FOREIGN KEY (employeeId) REFERENCES Employees (id) ON DELETE RESTRICT
);