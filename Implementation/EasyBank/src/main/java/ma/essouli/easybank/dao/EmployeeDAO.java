package ma.essouli.easybank.dao;

import java.util.Optional;

import ma.essouli.easybank.dto.Employee;

public interface EmployeeDAO extends Dao<Employee> {
    
    Optional<Employee> searchByRegistrationCode(int id);
}
