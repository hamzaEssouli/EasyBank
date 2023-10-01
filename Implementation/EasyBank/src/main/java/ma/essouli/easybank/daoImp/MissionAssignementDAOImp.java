package ma.essouli.easybank.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.MissionAssignmentDAO;
import ma.essouli.easybank.dto.MissionAssignment;
import ma.essouli.easybank.utilities.DataBaseAccessLayer;

public class MissionAssignementDAOImp implements MissionAssignmentDAO {

    private static MissionAssignementDAOImp insatnce = null;

    private Connection connection = null;
    private EmployeeDAOImp employeeDAO = null;
    private MissionDAOImp missionDAO = null;

    private MissionAssignementDAOImp() {
        this.connection = DataBaseAccessLayer.getConnection();
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
        try( PreparedStatement preparedStatement = connection.prepareStatement(insertQuery) ) {
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
    public HashMap<String, Integer> statistics(int missionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'statistics'");
    }

    @Override
    public List<MissionAssignment> findByEmployee(int employeeId) {
        String findQuery = "SELECT * FROM missionAssignments WHERE employeeId = ?";
        List<MissionAssignment> assignments = new ArrayList<>();
        try( PreparedStatement preparedStatement = connection.prepareStatement(findQuery) ) {
            preparedStatement.setInt(1, employeeId);

            ResultSet result = preparedStatement.executeQuery();

            while( result.next() ) {
                MissionAssignment assignment = new MissionAssignment();
                assignment.setAssignmentStartDate( LocalDate.parse( result.getDate("assignmentStartDate").toString() ) );
                assignment.setAssignmentEndDate( LocalDate.parse( result.getDate("assignmentEndDate").toString() ) );
                assignment.setEmployee( employeeDAO.searchByRegistrationCode(employeeId).get() );
                assignment.setMission( missionDAO.find( result.getInt( "missionId" ) ).get() );

                assignments.add(assignment);

            }
            
        }catch( SQLException e ) { e.printStackTrace(); }

        return assignments;
    }

    @Override
    public boolean delete(int missionId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
