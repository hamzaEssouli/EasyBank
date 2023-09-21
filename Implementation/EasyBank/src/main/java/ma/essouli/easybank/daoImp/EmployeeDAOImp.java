package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.EmployeeDAO;
import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class EmployeeDAOImp implements EmployeeDAO {

    private Connection connection = null;
    private static EmployeeDAOImp instance = null;

    private EmployeeDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
    }
    public static EmployeeDAOImp getInstance() {
        if(instance == null)
            instance = new EmployeeDAOImp();
        return instance;
    }

    @Override
    public Optional<Employee> create(Employee employee) {
        String insertQuery = "INSERT INTO Employees( firstName, lastName, dateOfBirth, phoneNumber, recruitmentDate, email )" +
                             "VALUES( ? , ? , ? , ? , ?, ? )";
        try( PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS) ) {
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setObject(3, employee.getDateOfBirth());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setObject(5, employee.getRecruitmentDate());
            preparedStatement.setString(6, employee.getEmail());
            
            if( preparedStatement.executeUpdate() > 0 ) {
                ResultSet generatedKey = preparedStatement.getGeneratedKeys();
                if( generatedKey.next() ) {
                    int generatedId = generatedKey.getInt(1);
                    employee.setId(generatedId);
                    return Optional.of(employee);
                }
            }
        } catch (SQLException e) { System.out.println(employee.getPhoneNumber()); e.printStackTrace(); }

        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(Employee t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Employee> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Employee> searchByRegistrationCode(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchByRegistrationCode'");
    }
    
}
