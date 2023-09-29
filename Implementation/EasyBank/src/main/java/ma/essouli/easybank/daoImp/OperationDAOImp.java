package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Optional;

import ma.essouli.easybank.dao.OperationDAO;
import ma.essouli.easybank.dto.Operation;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class OperationDAOImp implements OperationDAO {

    private static OperationDAOImp instance = null;

    private Connection connection = null;
    private AccountDAOImp accountDAO = null;
    private EmployeeDAOImp employeeDAO = null;
    
    private OperationDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
        accountDAO = AccountDAOImp.getInstance();
        employeeDAO = EmployeeDAOImp.getInstance();
    } 

    public static OperationDAOImp getInstance() {
        if( instance == null )
            instance = new OperationDAOImp();
        return instance;
    }


    @Override
    public Optional<Operation> create(Operation operation) {
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
                    operation.setDate(LocalDate.now());
                    return Optional.of(operation);
                }
            }
            
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0); }

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
    public Optional<Operation> search(int operationId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
}
