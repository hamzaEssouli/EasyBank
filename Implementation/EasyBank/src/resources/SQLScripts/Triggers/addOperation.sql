CREATE TRIGGER update_balance_before_insert_trigger
BEFORE INSERT ON operations
FOR EACH ROW
EXECUTE FUNCTION update_balance_before_insert();