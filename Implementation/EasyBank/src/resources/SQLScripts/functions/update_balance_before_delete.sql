CREATE OR REPLACE FUNCTION update_balance_before_delete() 
RETURNS TRIGGER AS $$
BEGIN
    IF OLD.type = 'DIPOSIT'::operationType THEN
        UPDATE Accounts 
        SET balance = balance - OLD.amount 
        WHERE id = OLD.accountId;
    ELSIF OLD.type = 'WITHDRAWAL'::operationType THEN
        UPDATE Accounts 
        SET balance = balance + OLD.amount 
        WHERE id = OLD.accountId;
    END IF;
    RETURN OLD;
END;
$$
LANGUAGE plpgsql;