package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.SavingAccountDAO;
import ma.essouli.easybank.dto.SavingAccount;
import ma.essouli.easybank.enums.AccountStatus;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class SavingAccountDAOImp implements SavingAccountDAO {

    private Connection connection = null;
    private static SavingAccountDAOImp instance = null;
    private ClientDAOImp clientDAO = null;

    private SavingAccountDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
        clientDAO = ClientDAOImp.getInstance();
    }
    public static SavingAccountDAOImp getInstance() {
        if(instance == null)
            instance = new SavingAccountDAOImp();
        return instance;
    }

    @Override
    public Optional<SavingAccount> create(SavingAccount account) {
        String insertQuery = "INSERT INTO savingAccounts(id, interestRate) VALUES(?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setDouble(2, account.getInterestRate());

            if( preparedStatement.executeUpdate() > 0 )
                    return Optional.of(account);
            
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0); }

        return Optional.empty();
    }

     @Override
    public Optional<SavingAccount> update(SavingAccount account) {
        String updateQuery = "UPDATE SavingAccounts SET interestRate = ? WHERE id = ?";
        try( PreparedStatement preparedStatement = connection.prepareStatement(updateQuery) ) {
            preparedStatement.setDouble(1, account.getInterestRate());
            preparedStatement.setInt(2, account.getId());

            if(preparedStatement.executeUpdate() > 0) 
                return Optional.of(account);
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0);}

        return Optional.empty();
    }

    @Override
    public List<SavingAccount> searchByClient(int clientId) {
        String readQuery = "SELECT * FROM savingAccounts JOIN Accounts ON Accounts.id = SavingAccounts.id WHERE clientId = ?";
        List<SavingAccount> accounts = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
            preparedStatement.setInt(1, clientId);

            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                SavingAccount account = new SavingAccount();
                account.setId(result.getInt("id"));
                account.setBalance(result.getDouble("balance"));
                account.setCreationDate(LocalDate.parse( result.getDate("creationDate").toString() ) );
                account.setInterestRate(result.getFloat("interestRate"));
                account.setStatus( AccountStatus.valueOf( result.getString("status") ) );
                
                accounts.add(account);
            }
        } catch( SQLException e) { e.printStackTrace(); }
        
        return accounts;
    }

    @Override
    public List<SavingAccount> searchByOperation(int operationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByOperation'");
    }
    @Override
    public Optional<SavingAccount> find(int accountId) {
        String findQuery = "SELECT * FROM savingAccounts JOIN Accounts ON Accounts.id = savingAccounts.id WHERE savingAccounts.id = ?";

        try( PreparedStatement preparedStatement = connection.prepareStatement(findQuery) ) {
            preparedStatement.setInt(1, accountId);

            ResultSet result = preparedStatement.executeQuery();
            if( result.next() ) {
                SavingAccount account = new SavingAccount();
                account.setId(result.getInt("id"));
                account.setBalance(result.getDouble("balance"));
                account.setCreationDate(LocalDate.parse( result.getDate("creationDate").toString() ) );
                account.setStatus( AccountStatus.valueOf( result.getString("status") ));
                account.setClient( clientDAO.searchById(result.getInt("clientId")).get() );
                account.setInterestRate( result.getFloat("interestRate") );

                return Optional.of(account);
            }
        } catch( SQLException e ) { e.printStackTrace();  }

        return Optional.empty();
    }
    
}
