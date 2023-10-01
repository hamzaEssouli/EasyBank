package ma.essouli.easybank.services;

import java.util.HashMap;
import java.util.Optional;

import ma.essouli.easybank.daoImp.MissionAssignementDAOImp;
import ma.essouli.easybank.dto.MissionAssignment;

public class MissionAssignementService {
    
    private static MissionAssignementService instance = null;

    private MissionAssignementDAOImp missionAssignmentDAO = null;

    private MissionAssignementService() {
        this.missionAssignmentDAO = MissionAssignementDAOImp.getInsatnce();
    }

    public static MissionAssignementService getInstance() {
        if( instance == null )
            instance = new MissionAssignementService();
        return instance;
    }

    public MissionAssignment create(MissionAssignment assignment) {
        Optional<MissionAssignment> optionalAssignment = missionAssignmentDAO.create(assignment);
        return optionalAssignment.isPresent() ?
            optionalAssignment.get()
        :
            null; 
    }

    public HashMap<String, Integer> statistics() {
        return missionAssignmentDAO.statistics();
    }

    public boolean delete() {
        return missionAssignmentDAO.delete();
    }
}
