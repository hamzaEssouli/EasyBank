package ma.essouli.easybank.services;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.daoImp.MissionDAOImp;
import ma.essouli.easybank.dto.Mission;

public class MissionService {
    
    private static MissionService instance = null;

    private MissionDAOImp missionDAO = null;
    
    private MissionService() {
        this.missionDAO = MissionDAOImp.getInstance();
    }

    public static MissionService getInstance() {
        if( instance == null ) 
            instance = new MissionService();
        return instance;
    }

    public Mission create(Mission mission) {
        Optional<Mission> optionalMission = missionDAO.create(mission);
        return optionalMission.isPresent() ?
            optionalMission.get()
        :
            null;
    }

    public boolean delete(int missionId) {
        return missionDAO.delete(missionId);
    }

    public List<Mission> read() {
        return missionDAO.read();
    }
    
}
