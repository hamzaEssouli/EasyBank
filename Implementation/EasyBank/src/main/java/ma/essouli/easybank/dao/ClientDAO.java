package ma.essouli.easybank.dao;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Employee;

public interface ClientDAO extends Dao<Client> {
    
    Optional<Client> search(String attribute);
    Optional<Client> searchById(int clientId);
    List<Account> getAccounts(int clientId);
    Optional<Employee> getEmployee(int employeeId);

}
