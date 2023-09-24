package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.EmployeeDAO;
import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.dto.Mission;
import ma.essouli.easybank.dto.MissionAssignment;
import ma.essouli.easybank.dto.Operation;
import ma.essouli.easybank.enums.OperationType;
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
        } catch (SQLException e) { e.printStackTrace(); }

        return Optional.empty();
    }

    @Override
    public Optional<Employee> update(Employee employee) {
        String updateQuery = "UPDATE employees SET\n" + //
                "firstName = ?,\n" + //
                "lastName = ?,\n" + //
                "dateOfBirth = ?,\n" + //
                "phoneNumber = ?,\n" + //
                "recruitmentDate = ?,\n" + //
                "email = ?\n" + //
                "WHERE id = ?;";
        
        try( PreparedStatement preparedStatement = connection.prepareStatement(updateQuery) ) {
            preparedStatement.setString(1, employee.getLastName());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setObject(3, employee.getDateOfBirth());
            preparedStatement.setString(4, employee.getPhoneNumber());
            preparedStatement.setObject(5, employee.getRecruitmentDate());
            preparedStatement.setString(6, employee.getEmail());
            preparedStatement.setInt(7, employee.getId());   

                
                if( preparedStatement.executeUpdate() > 0 ) 
                    return Optional.of(employee);
        } catch( Exception e ) { e.printStackTrace(); }

        return Optional.empty();
    }

    @Override
    public List<Employee> read() {
        String readQuery = "SELECT * FROM Employees";
        List<Employee> employees = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while( resultSet.next() ) {
                Employee employee = new Employee();
                employee.setId( resultSet.getInt("id") );
                employee.setLastName(resultSet.getString("lastName"));
                employee.setFirstName(resultSet.getString("firstName"));
                employee.setDateOfBirth(LocalDate.parse(resultSet.getDate("dateOfBirth").toString()));
                employee.setPhoneNumber(resultSet.getString("phoneNumber"));
                employee.setRecruitmentDate(LocalDate.parse(resultSet.getDate("recruitmentDate").toString()));
                employee.setEmail(resultSet.getString("email"));

                employees.add(employee);
            }
        } catch( Exception e ) { e.printStackTrace(); }

        return employees;
    }

    @Override
    public boolean delete(int id) {
        String deleteQuery = "DELETE FROM employees WHERE id = ?";
        int deletedCount = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);

            deletedCount = preparedStatement.executeUpdate();
        } catch( SQLException e ) { e.printStackTrace(); }
        return (deletedCount > 0) ? true : false;
    }

    @Override
    public Optional<Employee> searchByRegistrationCode(int id) {
        String searchByRegistrationCodeQuery = "SELECT * FROM Employees WHERE id = ?"; 
        try(PreparedStatement preparedStatement = connection.prepareStatement(searchByRegistrationCodeQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if( result.next() ) {
                Employee employee = new Employee();
                employee.setId(result.getInt("id"));
                employee.setLastName(result.getString("lastName"));
                employee.setFirstName(result.getString("firstName"));
                employee.setDateOfBirth(LocalDate.parse(result.getDate("dateOfBirth").toString()));
                employee.setPhoneNumber(result.getString("phoneNumber"));
                employee.setRecruitmentDate(LocalDate.parse(result.getDate("recruitmentDate").toString()));
                employee.setEmail(result.getString("email"));

                return Optional.of(employee);
            }
        } catch( SQLException e ) { e.printStackTrace(); }
        
        return Optional.empty();
    }





    @Override
    public List<Client> getClients(int employeeId) {
        String getClientsQuery = "SELECT * FROM Clients WHERE employeeId = ?";
        List<Client> clients = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(getClientsQuery)) {
            preparedStatement.setInt(1, employeeId);
            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                Client client = new Client();
                client.setId(result.getInt("id"));
                client.setLastName(result.getString("lastName"));
                client.setFirstName(result.getString("firstName"));
                client.setDateOfBirth(LocalDate.parse(result.getDate("dateOfBirth").toString()));
                client.setPhoneNumber(result.getString("phoneNumber"));
                client.setAddress(result.getString("address"));
                
                clients.add(client);
            }
        } catch( SQLException e ) { e.printStackTrace(); }

        return clients;
    }

    @Override
    public List<MissionAssignment> getMissionAssignments(int employeeId) {
        String getMissionAssignmentsQuery = "SELECT assignment.employeeId, " + //
                "assignment.missionId, " + //
                "mission.name, " + //
                "mission.description, " +
                "assignment.assignmentstartdate, " + //
                "assignment.assignmentenddate " + //
                "FROM MissionAssignments AS assignment " + //
                "JOIN Missions AS mission " + //
                "ON mission.id =  assignment.missionId " + //
                "WHERE employeeId = ?;";
        List<MissionAssignment> missionAssignments = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(getMissionAssignmentsQuery)) {
            preparedStatement.setInt(1, employeeId);
            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                MissionAssignment missionAssignment = new MissionAssignment();
                missionAssignment.setAssignmentStartDate( LocalDate.parse( result.getDate("assignmentStartDate").toString() ) );
                missionAssignment.setAssignmentEndDate( LocalDate.parse( result.getDate("assignmentenddate").toString() )  );
                missionAssignment.setMission( new Mission(result.getInt("missionId"), result.getString("name"), result.getString("description")) );

                missionAssignments.add(missionAssignment);
            }
        } catch( SQLException e ) { e.printStackTrace(); }

        return missionAssignments;
    }

    @Override
    public List<Operation> getOperations(int employeeId) {
        String getOperationsQuery = "SELECT * FROM Operations WHERE employeeId = ?";
        List<Operation> operations = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(getOperationsQuery)) {
            preparedStatement.setInt(1, employeeId);
            ResultSet result = preparedStatement.executeQuery();
            while( result.next() ) {
                Operation operation = new Operation();
                Account account = new Account();
                account.setId(result.getInt("accountId"));
                operation.setId(result.getInt("id"));
                operation.setAmount(result.getDouble("amount"));
                operation.setDate( LocalDate.parse(result.getDate("date").toString()) );
                operation.setType( OperationType.valueOf(result.getString("type")) );
                operation.setAccount(account);

                operations.add(operation);
            }
        } catch( SQLException e ) { e.printStackTrace(); }

        return operations;
    }
    
    
}
