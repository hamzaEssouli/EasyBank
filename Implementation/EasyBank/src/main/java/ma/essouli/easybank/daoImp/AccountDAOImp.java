package ma.essouli.easybank.daoImp;

import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    public Optional<Account> show(int accountId) {
        // TODO Auto-generated method 
        throw new UnsupportedOperationException("Unimplemented method 'show'");
    }

    @Override
    public Optional<Account> update(Account account) {
        String updateStatusQuery = "UPDATE Accounts SET status = ? WHERE id = ?";
        try( PreparedStatement preparedStatement = connection.prepareStatement(updateStatusQuery) ) {
            preparedStatement.setObject(1, account.getStatus(), Types.OTHER);
            preparedStatement.setInt(2, account.getId());

            if(preparedStatement.executeUpdate() > 0) 
                return Optional.of(account);
        } catch( SQLException e ) { e.printStackTrace(); }

        return Optional.empty();
    }
    @Override
    public List<Account> read() {
        String readQuery = "SELECT * FROM accounts";
        List<Account> accounts = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                Account account = new Account();
                account.setId(result.getInt("id"));
                account.setBalance(result.getDouble("balance"));
                account.setCreationDate(LocalDate.parse( result.getDate("creationDate").toString() ) );
                account.setStatus( AccountStatus.valueOf( result.getString("status") ));
                
                accounts.add(account);
            }
        } catch( Exception e ) { e.printStackTrace(); }

        return accounts;
    }
    @Override
    public List<Account> displayAccountsByStatus(AccountStatus status) {
        String readQuery = "SELECT * FROM accounts WHERE status = ?";
        List<Account> accounts = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
            preparedStatement.setObject(1, status,  Types.OTHER);
            
            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                Account account = new Account();
                account.setId(result.getInt("id"));
                account.setBalance(result.getDouble("balance"));
                account.setCreationDate(LocalDate.parse( result.getDate("creationDate").toString() ) );
                account.setStatus( AccountStatus.valueOf( result.getString("status") ));
                
                accounts.add(account);
            }
        } catch( Exception e ) { e.printStackTrace(); }

        return accounts;
    }
    @Override
    public List<Account> displayAccountsByCreationDate(LocalDate creationDate) {
        String readQuery = "SELECT * FROM accounts WHERE creationDate = ?";
        List<Account> accounts = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
            preparedStatement.setObject(1,  creationDate);
            
            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                Account account = new Account();
                account.setId(result.getInt("id"));
                account.setBalance(result.getDouble("balance"));
                account.setCreationDate(LocalDate.parse( result.getDate("creationDate").toString() ) );
                account.setStatus( AccountStatus.valueOf( result.getString("status") ));
                
                accounts.add(account);
            }
        } catch( Exception e ) { e.printStackTrace();  }

        return accounts;
    }
   
    


   
    
}
