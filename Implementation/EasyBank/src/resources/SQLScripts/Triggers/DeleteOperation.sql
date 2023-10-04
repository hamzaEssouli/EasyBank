CREATE TRIGGER update_balance_before_delete_trigger
BEFORE DELETE ON operations
FOR EACH ROW
EXECUTE FUNCTION update_balance_before_delete();