package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import ma.essouli.easybank.dao.CurrentAccountDAO;
import ma.essouli.easybank.dto.CurrentAccount;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class CurrentAccountDAOImp implements CurrentAccountDAO {

    private Connection connection = null;
    private static CurrentAccountDAOImp instance = null;

    private CurrentAccountDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    
}