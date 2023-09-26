package ma.essouli.easybank.daoImp;

import java.sql.Statement;
import java.sql.Types;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.AccountDAO;
import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.enums.AccountStatus;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class AccountDAOImp implements AccountDAO {

    private Connection connection = null;
    private static AccountDAOImp instance = null;

    private AccountDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
    }
    public static AccountDAOImp getInstance() {
        if(instance == null)
            instance = new AccountDAOImp();
        return instance;
    }

    @Override
    public Optional<Account> create(Account account) {
        String insertQuery = "INSERT INTO Accounts(clientId, balance, creationDate, status) VALUES(?, ?, ?, ?)";
        try( PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS)  ) {
            preparedStatement.setInt(1, account.getClient().getId());
            preparedStatement.setDouble(2, account.getBalance());
            preparedStatement.setObject(3, account.getCreationDate());
            preparedStatement.setObject(4, account.getStatus(), Types.OTHER);

            if( preparedStatement.executeUpdate() > 0 ) {
                ResultSet generatedKey = preparedStatement.getGeneratedKeys();
                if( generatedKey.next() ) {
                    int generatedId = generatedKey.getInt(1);
                    account.setId(generatedId);
                    return Optional.of(account);
                }
            }
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0); }

        return Optional.empty();
    }

    @Override
    public Optional<Account> update(Account t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Account> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int accountId) {
        String deleteQuery = "DELETE FROM accounts WHERE id = ?";
        int deletedCount = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, accountId );

            deletedCount = preparedStatement.executeUpdate();
        } catch( SQLException e ) { e.printStackTrace(); }
        return (deletedCount > 0) ? true : false;
    }

    @Override
    public List<Account> searchByClient(int clientId) {
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
