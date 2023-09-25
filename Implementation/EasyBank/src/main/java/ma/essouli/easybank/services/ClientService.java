package ma.essouli.easybank.services;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.daoImp.ClientDAOImp;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Employee;


public class ClientService {

    private ClientDAOImp clientDAO = null;
    private static ClientService instance = null;

    private ClientService() {
        this.clientDAO = ClientDAOImp.getInstance();
    }
    public static ClientService getInstance() {
        if( instance == null )
            instance = new ClientService();
        return instance;
    }

    public Client create(Client client) {
        Optional<Client> optionalClient = clientDAO.create(client);
        return optionalClient.isPresent() ? 
            optionalClient.get()
        :
            null;
    }

    public boolean delete(int id) {
        return clientDAO.delete(id);
    }

    public Client searchByRegistrationCode(int id) {
        Optional<Client> optionalClient = clientDAO.searchById(id);
        return optionalClient.isPresent() ?
            optionalClient.get()
        :
            null;
    }

    public List<Client> read() {
        return clientDAO.read();
    }

    public Employee getEmployee(int employeeId) {
        Optional<Employee> optionalEmployee = clientDAO.getEmployee(employeeId);
        return optionalEmployee.isPresent() ?
            optionalEmployee.get()
        :
            null;
    }
}
