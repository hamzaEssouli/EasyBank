CREATE TABLE AgencyAssignements (
	agency_id int,
	account_id int,
	start_date DATE NOT NULL DEFAULT CURRENT_DATE,	
	end_date DATE,
	FOREIGN KEY (agency_id) REFERENCES agencies(id) ON DELETE SET NULL,
	FOREIGN KEY (account_id) REFERENCES accounts(id) ON DELETE SET NULL
);