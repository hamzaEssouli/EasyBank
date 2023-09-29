package ma.essouli.easybank.dao;

import java.util.Optional;

import ma.essouli.easybank.dto.Operation;

public interface OperationDAO {
    
    Optional<Operation> create(Operation operation);
    boolean delete(int operationId);
    Optional<Operation> search(int operationId);
}
