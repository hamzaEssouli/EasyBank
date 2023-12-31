CREATE TABLE Accounts (
	id SERIAL NOT NULL UNIQUE PRIMARY KEY,
	clientId INT NOT NULL,
	balance DOUBLE PRECISION NOT NULL DEFAULT 0.0,
	creationDate DATE NOT NULL DEFAULT CURRENT_DATE,
	Status accountStatus NOT NULL DEFAULT 'ACTIVE',
	FOREIGN KEY (clientId) REFERENCES Clients (id) ON DELETE CASCADE
);