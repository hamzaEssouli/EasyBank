package ma.essouli.easybank.daoImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.AccountDAO;
import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.enums.AccountStatus;

public class AccountDAOImp implements AccountDAO {

    @Override
    public int delete(int accountid) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<Account> searchByClient(Client client) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByClient'");
    }

    @Override
    public Optional<Account> searchByOperationId(int operationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByOperationId'");
    }

    @Override
    public List<Account> displayByStatus(AccountStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayByStatus'");
    }

    @Override
    public List<Account> displayByCreationDate(LocalDate creationDate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'displayByCreationDate'");
    }
    
}
