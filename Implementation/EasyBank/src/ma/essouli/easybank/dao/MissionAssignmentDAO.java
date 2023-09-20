package ma.essouli.easybank.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface MissionAssignmentDAO {
    
    Optional<MissionAssignmentDAO> create(MissionAssignmentDAO missionAssignment);
    List<MissionAssignmentDAO> read(int employeeId);
    boolean delete(int missionId);
    HashMap<String, Integer> statistics(int missionId);

}
