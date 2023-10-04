package ma.essouli.easybank.daoImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.TransactionDAO;

public class TransactionDAOImp implements TransactionDAO {

    private static TransactionDAOImp instance = null;

    // dependencies 
    private AccountDAOImp accountDAO = null;

    private TransactionDAOImp() {
        this.accountDAO = AccountDAOImp.getInstance();
    }

    public static TransactionDAOImp getInstance() {
        if( instance == null )
            instance = new TransactionDAOImp();
        return instance;
    }

    @Override
    public Optional<TransactionDAO> create(TransactionDAO transaction) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public boolean delete(int transactionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<TransactionDAO> find(int transactionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'find'");
    }

    @Override
    public List<TransactionDAO> getByAccount(int accountId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByAccount'");
    }

    @Override
    public List<TransactionDAO> getByDate(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByDate'");
    }


}
