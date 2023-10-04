CREATE TABLE CreditRequests (
	id SERIAL NOT NULL PRIMARY KEY,
	client_id int,
	agency_id int,
	amount DOUBLE PRECISION NOT NULL,
	date DATE NOT NULL DEFAULT CURRENT_DATE,
	duration int NOT NULL,
	remark VARCHAR(255),
	status CreditRequestStatus DEFAULT 'PENDING'::CreditRequestStatus,
	FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE SET NULL,
	FOREIGN KEY (agency_id) REFERENCES agencies(id) ON DELETE SET NULL
);