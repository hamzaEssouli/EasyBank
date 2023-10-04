package ma.essouli.easybank.dao;

import java.util.Optional;

import ma.essouli.easybank.dto.SimpleOperation;

public interface SimpleOperationDAO {
    
    Optional<SimpleOperation> create(SimpleOperation operation);
    boolean delete(int operationId);
    Optional<SimpleOperation> search(int operationId);
    
}
