CREATE OR REPLACE FUNCTION update_balance_before_insert() 
RETURNS TRIGGER AS $$
BEGIN
    IF NEW.type = 'DIPOSIT'::operationType THEN
        UPDATE Accounts 
        SET balance = balance + NEW.amount 
        WHERE id = NEW.accountId;
    ELSIF NEW.type = 'WITHDRAWAL'::operationType THEN
        IF NEW.amount > (SELECT balance FROM Accounts WHERE id = NEW.accountId) THEN
            RAISE EXCEPTION 'Insufficient funds for withdrawal';
        ELSE
            UPDATE Accounts 
            SET balance = balance - NEW.amount 
            WHERE id = NEW.accountId;
        END IF;
    END IF;
    RETURN NEW;
END;
$$
LANGUAGE plpgsql;