package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

import ma.essouli.easybank.dao.SavingAccountDAO;
import ma.essouli.easybank.dto.SavingAccount;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class SavingAccountDAOImp implements SavingAccountDAO {

    private Connection connection = null;
    private static SavingAccountDAOImp instance = null;

    private SavingAccountDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}
