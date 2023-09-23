package ma.essouli.easybank.dao;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.dto.MissionAssignment;
import ma.essouli.easybank.dto.Operation;

public interface EmployeeDAO extends Dao<Employee> {
    
    Optional<Employee> searchByRegistrationCode(int employeeId);
    List<Client> getClients(int employeeId);
    List<MissionAssignment> getMissionAssignments(int employeeId);
    List<Operation> getOperations(int employeeId);
}
