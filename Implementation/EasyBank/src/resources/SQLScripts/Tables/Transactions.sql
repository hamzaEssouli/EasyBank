CREATE TABLE Transactions (
	id SERIAL NOT NULL PRIMARY KEY,
	src_account_id  int,
	dist_account_id int,
	amount DOUBLE PRECISION NOT NULL,
	date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (src_account_id) REFERENCES accounts(id) ON DELETE SET NULL,
	FOREIGN KEY (dist_account_id) REFERENCES accounts(id) ON DELETE SET NULL	
	
);