package ma.essouli.easybank.services;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.daoImp.EmployeeDAOImp;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.dto.MissionAssignment;
import ma.essouli.easybank.dto.Operation;

public class EmployeeService {
    
    private EmployeeDAOImp employeeDAO = null;
    private static EmployeeService instance = null;

    private EmployeeService() {
        this.employeeDAO = EmployeeDAOImp.getInstance();
    }
    public static EmployeeService getInstance() {
        if( instance == null )
            instance = new EmployeeService();
        return instance;
    }

    public Employee create(Employee employee) {
        Optional<Employee> optionalEmployee = employeeDAO.create(employee);
        return optionalEmployee.isPresent() ? 
            optionalEmployee.get()
        :
            null;
    }
    
    public boolean delete(int id) {
        return employeeDAO.delete(id);
    }

    public Employee searchByRegistrationCode(int id) {
        Optional<Employee> optionalEmployee = employeeDAO.searchByRegistrationCode(id);
        return optionalEmployee.isPresent() ?
            optionalEmployee.get()
        :
            null;
    }

    public List<Employee> read() {
        return employeeDAO.read();
    }

    public Employee update(Employee employee) {
        Optional<Employee> optionalEmployee = employeeDAO.update(employee);
        return optionalEmployee.isPresent() ?
            optionalEmployee.get()
        :
            null;
    } 

    public List<Employee> search(String attribut) {
        return employeeDAO.search(attribut);
    }

    public List<Client> getClients(int employeeId) {
        List<Client> clients = employeeDAO.getClients(employeeId);
        return clients;
    }

    public List<MissionAssignment> getMissionAssignments(int employeeId) {
        List<MissionAssignment> missionAssignments = employeeDAO.getMissionAssignments(employeeId);
        return missionAssignments;
    }

    public List<Operation> getOperations(int employeeId) {
        List<Operation> operations = employeeDAO.getOperations(employeeId);
        return operations;
    }

}
