package ma.essouli.easybank.services;

import java.util.Optional;

import ma.essouli.easybank.daoImp.OperationDAOImp;
import ma.essouli.easybank.dto.Operation;

public class OperationService {
    
    private static OperationService instance = null;

    private OperationDAOImp operationDAO = null;

    private OperationService() {
        operationDAO = OperationDAOImp.getInstance();
    }

    public static OperationService getInstance() {
        if( instance == null )
            instance = new OperationService();
        return instance;
    }

    public Operation create(Operation operation) {
        Optional<Operation> optionalOperation = operationDAO.create(operation);
        return optionalOperation.isPresent() ?
            optionalOperation.get()
        :
            null;
    }

    public boolean delete(int id) {
        return operationDAO.delete(id);
    }
    

    public Operation search(int operationId) {
        Optional<Operation> optionalOperation = operationDAO.search(operationId);

        return optionalOperation.isPresent() ?
            optionalOperation.get()
        :
            null;
    }
}
