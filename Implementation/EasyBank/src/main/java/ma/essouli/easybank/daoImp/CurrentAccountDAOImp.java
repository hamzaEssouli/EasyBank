package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.CurrentAccountDAO;
import ma.essouli.easybank.dto.CurrentAccount;
import ma.essouli.easybank.enums.AccountStatus;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class CurrentAccountDAOImp implements CurrentAccountDAO {

    private Connection connection = null;
    private static CurrentAccountDAOImp instance = null;
    private ClientDAOImp clientDAO = null;

    private CurrentAccountDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
        clientDAO = ClientDAOImp.getInstance();
    }
    public static CurrentAccountDAOImp getInstance() {
        if(instance == null)
            instance = new CurrentAccountDAOImp();
        return instance;
    }


    @Override
    public Optional<CurrentAccount> create(CurrentAccount account) {
        String insertQuery = "INSERT INTO currentAccounts(id, overdraft) VALUES(?, ?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, account.getId());
            preparedStatement.setDouble(2, account.getOverdraft());

            if( preparedStatement.executeUpdate() > 0 )
                    return Optional.of(account);
            
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0); }

        return Optional.empty();
    }

    @Override
    public Optional<CurrentAccount> update(CurrentAccount account) {
        String updateQuery = "UPDATE CurrentAccounts SET overdraft = ? WHERE id = ?";
        try( PreparedStatement preparedStatement = connection.prepareStatement(updateQuery) ) {
            preparedStatement.setDouble(1, account.getOverdraft());
            preparedStatement.setInt(2, account.getId());

            if(preparedStatement.executeUpdate() > 0) 
                return Optional.of(account);
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0);}

        return Optional.empty();
    }

    @Override
    public List<CurrentAccount> searchByClient(int clientId) {
        String readQuery = "SELECT * FROM currentAccounts JOIN Accounts ON Accounts.id = currentAccounts.id WHERE clientId = ?";
        List<CurrentAccount> accounts = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
            preparedStatement.setInt(1, clientId);

            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                CurrentAccount account = new CurrentAccount();
                account.setId(result.getInt("id"));
                account.setBalance(result.getDouble("balance"));
                account.setCreationDate(LocalDate.parse( result.getDate("creationDate").toString() ) );
                account.setOverdraft(result.getFloat("overdraft"));
                account.setStatus( AccountStatus.valueOf( result.getString("status") ) );
                
                accounts.add(account);
            }
        } catch( SQLException e) { e.printStackTrace(); }
        
        return accounts;
    }
    @Override
    public List<CurrentAccount> searchByOperation(int operationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByOperation'");
    }
    @Override
    public Optional<CurrentAccount> find(int accountId) {
        String findQuery = "SELECT * FROM currentAccounts JOIN Accounts ON Accounts.id = currentAccounts.id WHERE currentAccounts.id = ?";

        try( PreparedStatement preparedStatement = connection.prepareStatement(findQuery) ) {
            preparedStatement.setInt(1, accountId);

            ResultSet result = preparedStatement.executeQuery();
            if( result.next() ) {
                CurrentAccount account = new CurrentAccount();
                account.setId(result.getInt("id"));
                account.setBalance(result.getDouble("balance"));
                account.setCreationDate(LocalDate.parse( result.getDate("creationDate").toString() ) );
                account.setStatus( AccountStatus.valueOf( result.getString("status") ));
                account.setClient( clientDAO.searchById(result.getInt("clientId")).get() );
                account.setOverdraft( result.getFloat("overdraft") );

                return Optional.of(account);
            }
        } catch( SQLException e ) { e.printStackTrace(); }

        return Optional.empty();
    }
    
}
