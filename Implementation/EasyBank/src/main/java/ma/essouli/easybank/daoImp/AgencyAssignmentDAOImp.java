package ma.essouli.easybank.daoImp;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.AgencyAssignmentDAO;
import ma.essouli.easybank.dto.Agency;
import ma.essouli.easybank.dto.AgencyAssignment;
import ma.essouli.easybank.dto.Employee;

public class AgencyAssignmentDAOImp implements AgencyAssignmentDAO {

    private static AgencyAssignmentDAOImp instance = null;

    // dependencies
    private EmployeeDAOImp EmployeeDAO = null;
    private AgencyDAOImp AgencyDAO = null;

    private AgencyAssignmentDAOImp(){
        this.EmployeeDAO = EmployeeDAOImp.getInstance();
        this.AgencyDAO = AgencyDAOImp.getInstance();
    }

    public static AgencyAssignmentDAOImp getInstance() {
        if( instance == null )
            instance = new AgencyAssignmentDAOImp();
        return instance;
    }

    @Override
    public Optional<AgencyAssignment> create(AgencyAssignment assignment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public boolean delete(AgencyAssignment assignment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<AgencyAssignment> getByEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByEmployee'");
    }

    @Override
    public List<AgencyAssignment> getByAgency(Agency agency) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByAgency'");
    }

    @Override
    public HashMap<String, Integer> statistics() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'statistics'");
    }
    
}
