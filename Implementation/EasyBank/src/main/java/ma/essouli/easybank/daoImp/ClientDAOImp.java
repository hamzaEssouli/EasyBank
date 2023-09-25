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

import ma.essouli.easybank.dao.ClientDAO;
import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class ClientDAOImp implements ClientDAO {

    private Connection connection = null;
    private static ClientDAOImp instance = null;

    private ClientDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
    }
    public static ClientDAOImp getInstance() {
        if(instance == null)
            instance = new ClientDAOImp();
        return instance;
    }


    @Override
    public Optional<Client> create(Client client) {
        String insertQuery = "INSERT INTO Clients( firstName, lastName, dateOfBirth, phoneNumber, address, employeeId )" +
                             "VALUES( ? , ? , ? , ? , ?, ? )";
        try( PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS) ) {
            preparedStatement.setString(1, client.getLastName());
            preparedStatement.setString(2, client.getFirstName());
            preparedStatement.setObject(3, client.getDateOfBirth());
            preparedStatement.setString(4, client.getPhoneNumber());
            preparedStatement.setObject(5, client.getAddress());
            preparedStatement.setInt(6, client.getEmployee().getId());
            
            if( preparedStatement.executeUpdate() > 0 ) {
                ResultSet generatedKey = preparedStatement.getGeneratedKeys();
                if( generatedKey.next() ) {
                    int generatedId = generatedKey.getInt(1);
                    client.setId(generatedId);
                    return Optional.of(client);
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }

        return Optional.empty();
    }

    @Override
    public Optional<Client> update(Client t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Client> read() {
        String readQuery = "SELECT * FROM Clients";
        List<Client> clients = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(readQuery)) {
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
        } catch( Exception e ) { e.printStackTrace(); }

        return clients;
    }

    @Override
    public boolean delete(int id) {
        String deleteQuery = "DELETE FROM clients WHERE id = ?";
        int deletedCount = 0;
        try(PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, id);

            deletedCount = preparedStatement.executeUpdate();
        } catch( SQLException e ) { e.printStackTrace(); }
        return (deletedCount > 0) ? true : false;
    }

    @Override
    public Optional<Client> search(String attribute) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

    @Override
    public Optional<Client> searchById(int id) {
        String searchByRegistrationCodeQuery = "SELECT * FROM Clients WHERE id = ?"; 
        try(PreparedStatement preparedStatement = connection.prepareStatement(searchByRegistrationCodeQuery)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if( result.next() ) {
                Client client = new Client();
                Employee employee = new Employee();
                employee.setId(result.getInt("employeeId"));
                client.setEmployee(employee);
                client.setId(result.getInt("id"));
                client.setLastName(result.getString("lastName"));
                client.setFirstName(result.getString("firstName"));
                client.setDateOfBirth(LocalDate.parse(result.getDate("dateOfBirth").toString()));
                client.setPhoneNumber(result.getString("phoneNumber"));
                client.setAddress(result.getString("address"));

                return Optional.of(client);
            }
        } catch( SQLException e ) { e.printStackTrace(); }
        
        return Optional.empty();
    }
    @Override
    public List<Account> getAccounts(int clientId) {
        
        return new ArrayList<Account>();
    }
    @Override
    public Optional<Employee> getEmployee(int employeeId) {
        String getEmployeeQuery = "SELECT * FROM Employees WHERE id = ?"; 
        try(PreparedStatement preparedStatement = connection.prepareStatement(getEmployeeQuery)) {
            preparedStatement.setInt(1, employeeId);
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
    
}
