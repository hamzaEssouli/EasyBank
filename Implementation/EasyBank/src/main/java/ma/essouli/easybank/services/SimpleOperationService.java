package ma.essouli.easybank.services;

import java.util.Optional;

import ma.essouli.easybank.daoImp.SimpleOperationDAOImp;
import ma.essouli.easybank.dto.SimpleOperation;

public class SimpleOperationService {
    
    private static SimpleOperationService instance = null;

    private SimpleOperationDAOImp operationDAO = null;

    private SimpleOperationService() {
        operationDAO = SimpleOperationDAOImp.getInstance();
    }

    public static SimpleOperationService getInstance() {
        if( instance == null )
            instance = new SimpleOperationService();
        return instance;
    }

    public SimpleOperation create(SimpleOperation operation) {
        Optional<SimpleOperation> optionalOperation = operationDAO.create(operation);
        return optionalOperation.isPresent() ?
            optionalOperation.get()
        :
            null;
    }

    public boolean delete(int id) {
        return operationDAO.delete(id);
    }
    

    public SimpleOperation search(int operationId) {
        Optional<SimpleOperation> optionalOperation = operationDAO.search(operationId);

        return optionalOperation.isPresent() ?
            optionalOperation.get()
        :
            null;
    }
}
