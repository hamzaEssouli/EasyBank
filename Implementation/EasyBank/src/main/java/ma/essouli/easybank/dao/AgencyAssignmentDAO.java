package ma.essouli.easybank.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Agency;
import ma.essouli.easybank.dto.AgencyAssignment;
import ma.essouli.easybank.dto.Employee;

public interface AgencyAssignmentDAO {
    
    Optional<AgencyAssignment> create(AgencyAssignment assignment);
    boolean delete(AgencyAssignment assignment);
    List<AgencyAssignment> getByEmployee(Employee employee);
    List<AgencyAssignment> getByAgency(Agency agency);
    HashMap<String, Integer> statistics();
}
