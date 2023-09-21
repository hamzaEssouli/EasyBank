package ma.essouli.easybank.services;

import java.util.Optional;

import ma.essouli.easybank.daoImp.EmployeeDAOImp;
import ma.essouli.easybank.dto.Employee;

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
}
