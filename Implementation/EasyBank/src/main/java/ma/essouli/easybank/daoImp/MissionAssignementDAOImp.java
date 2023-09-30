package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.MissionAssignmentDAO;
import ma.essouli.easybank.dto.MissionAssignment;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class MissionAssignementDAOImp implements MissionAssignmentDAO {

    private static MissionAssignementDAOImp insatnce = null;

    private Connection connetion = null;
    private EmployeeDAOImp employeeDAO = null;
    private MissionDAOImp missionDAO = null;

    private MissionAssignementDAOImp() {
        this.connetion = DataBaseAccessLayer.getConnection();
        employeeDAO = EmployeeDAOImp.getInstance();
        missionDAO = MissionDAOImp.getInstance();
    }

    public static MissionAssignementDAOImp getInsatnce() {
        if( insatnce == null )
            insatnce = new MissionAssignementDAOImp();
        return insatnce;
    }


    @Override
    public Optional<MissionAssignment> create(MissionAssignment missionAssignment) {
        String insertQuery = "INSERT INTO MissionAssignments ( employeeId, missionId, assignmentStartDate ) VALUES ( ?, ?, ? )";
        try( PreparedStatement preparedStatement = connetion.prepareStatement(insertQuery) ) {
            preparedStatement.setInt(1, missionAssignment.getEmployee().getId());
            preparedStatement.setInt(2, missionAssignment.getMission().getId());
            preparedStatement.setObject(3, missionAssignment.getAssignmentStartDate());

            if( preparedStatement.executeUpdate() > 0 ) {
                missionAssignment.setEmployee( employeeDAO.searchByRegistrationCode( missionAssignment.getEmployee().getId() ).get() );
                missionAssignment.setMission( missionDAO.find( missionAssignment.getEmployee().getId() ).get() );
                
                return Optional.of(missionAssignment);
            }
                
        } catch( SQLException e ) { e.printStackTrace(); System.exit(0); }

        return Optional.empty();
    }

    @Override
    public List<MissionAssignmentDAO> read(int employeeId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int missionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public HashMap<String, Integer> statistics(int missionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'statistics'");
    }
    
}
