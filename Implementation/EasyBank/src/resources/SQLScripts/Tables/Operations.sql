CREATE TABLE Operations (
	id SERIAL NOT NULL UNIQUE PRIMARY KEY,
	accountId INT NOT NULL,
	employeeId INT NOT NULL,
	operationDate DATE NOT NULL DEFAULT CURRENT_DATE,
	type OperationType NOT NULL,
	FOREIGN KEY (accountId) REFERENCES accounts (id) ON DELETE SET NULL,
	FOREIGN KEY (employeeId) REFERENCES employees (id) ON DELETE SET NULL
	
);