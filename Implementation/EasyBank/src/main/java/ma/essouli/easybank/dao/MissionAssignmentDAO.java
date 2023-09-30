package ma.essouli.easybank.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.MissionAssignment;

public interface MissionAssignmentDAO {
    
    Optional<MissionAssignment> create(MissionAssignment missionAssignment);
    List<MissionAssignment> read(int employeeId);
    boolean delete(int missionId);
    HashMap<String, Integer> statistics(int missionId);

}
