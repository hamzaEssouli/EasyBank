package ma.essouli.easybank.dao;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Mission;

public interface MissionDAO {
    
    Optional<Mission> create(Mission missison);
    List<Mission> read();
    Optional<Mission> find(int misisonId);
    boolean delete(int id);
}
