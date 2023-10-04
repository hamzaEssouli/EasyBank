package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDateTime;
import java.util.Optional;


import ma.essouli.easybank.dao.SimpleOperationDAO;
import ma.essouli.easybank.dto.SimpleOperation;
import ma.essouli.easybank.enums.OperationType;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class SimpleOperationDAOImp implements SimpleOperationDAO {

    private static SimpleOperationDAOImp instance = null;

    private Connection connection = null;
    private AccountDAOImp accountDAO = null;
    private EmployeeDAOImp employeeDAO = null;
    
    private SimpleOperationDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
        accountDAO = AccountDAOImp.getInstance();
        employeeDAO = EmployeeDAOImp.getInstance();
    } 

    public static SimpleOperationDAOImp getInstance() {
        if( instance == null )
            instance = new SimpleOperationDAOImp();
        return instance;
    }


    @Override
    public Optional<SimpleOperation> create(SimpleOperation operation) {
        String insterQuery = "INSERT INTO Operations (accountId, employeeId, type, amount) VALUES (?, ?, ?, ?)";
        try( PreparedStatement preparedStatement = connection.prepareStatement(insterQuery, Statement.RETURN_GENERATED_KEYS) ) {
            preparedStatement.setInt(1, operation.getAccount().getId());
            preparedStatement.setInt(2, operation.getEmployee().getId());
            preparedStatement.setObject(3, operation.getType(),  Types.OTHER);
            preparedStatement.setDouble(4, operation.getAmount());

            if( preparedStatement.executeUpdate() > 0 ) {
                ResultSet generatedKey = preparedStatement.getGeneratedKeys();
                if( generatedKey.next() ) {
                    int generatedId = generatedKey.getInt(1);
                    operation.setId(generatedId);
                    operation.setAccount(accountDAO.find( operation.getAccount().getId() ).get());
                    operation.setDate(LocalDateTime.now());
                    return Optional.of(operation);
                }
            }
            
        } catch( SQLException e ) { e.printStackTrace();  }

        return Optional.empty();
    }

    @Override
    public boolean delete(int operationId) {
        String deleteQuery = "DELETE FROM operations WHERE id = ?";
        try( PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery) ) {
            preparedStatement.setInt(1, operationId);

            if( preparedStatement.executeUpdate() > 0 ) 
                return true;
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0);}

        return false;
    }

    @Override
    public Optional<SimpleOperation> search(int operationId) {
        String searchQuery = "SELECT * FROM Operations WHERE id = ?";

        try( PreparedStatement preparedStatement = connection.prepareStatement(searchQuery) ) {
            preparedStatement.setInt(1, operationId);

            ResultSet result = preparedStatement.executeQuery();
            if( result.next() ) {
                SimpleOperation  operation = new SimpleOperation();
                operation.setId(operationId);
                operation.setAmount(result.getDouble("amount"));
                operation.setDate( LocalDateTime.parse( result.getDate("date").toString() ) );
                operation.setType( OperationType.valueOf( result.getString("type") ) );
                operation.setAccount( accountDAO.find(result.getInt("accountId")).get() );
                operation.setEmployee( employeeDAO.searchByRegistrationCode(result.getInt("employeeId")).get() );

                return Optional.of(operation);
            }
                 
        } catch( SQLException e ) { e.printStackTrace();  }

        return Optional.empty();
    }

    
    
}
