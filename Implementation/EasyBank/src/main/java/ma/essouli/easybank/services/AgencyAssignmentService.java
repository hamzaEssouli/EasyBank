package ma.essouli.easybank.services;

public class AgencyAssignmentService {
    
    private static AgencyAssignmentService instance = null;

    private AgencyAssignmentService() {}

    public static AgencyAssignmentService getInstance() {
        if( instance == null )
            instance = new AgencyAssignmentService();
        return instance;
    }
}
