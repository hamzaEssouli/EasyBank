package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.ClientDAO;
import ma.essouli.easybank.dto.Client;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'searchById'");
    }
    
}
