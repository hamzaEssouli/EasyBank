package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.MissionDAO;
import ma.essouli.easybank.dto.Mission;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class MissionDAOImp implements MissionDAO {
    
    private static MissionDAOImp instance = null;

    private Connection connection = null;

    private MissionDAOImp() {
        connection = DataBaseAccessLayer.getConnection();
    }

    public static MissionDAOImp getInstance() {
        if( instance == null )
            instance = new MissionDAOImp();
        return instance;
    }


    @Override
    public Optional<Mission> create(Mission mission) {
        String insertQuery = "INSERT INTO Missions ( name, description ) VALUES (?, ?)";
        try( PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS) ) {
            preparedStatement.setString(1, mission.getName());
            preparedStatement.setString(2, mission.getDescription());

            if( preparedStatement.executeUpdate() > 0 ) {
                ResultSet generatedKey = preparedStatement.getGeneratedKeys();
                if( generatedKey.next() ) {
                    int generatedId = generatedKey.getInt(1);
                    mission.setId(generatedId);
                    return Optional.of(mission);
                }
            }
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0); }

        return Optional.empty();
    }

    @Override
    public List<Mission> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
