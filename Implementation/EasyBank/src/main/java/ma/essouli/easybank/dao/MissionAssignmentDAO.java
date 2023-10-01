package ma.essouli.easybank.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.MissionAssignment;

public interface MissionAssignmentDAO {
    
    Optional<MissionAssignment> create(MissionAssignment missionAssignment);
    boolean delete(int missionId);
    List<MissionAssignment> findByEmployee(int employeeId);
    HashMap<String, Integer> statistics();

}
