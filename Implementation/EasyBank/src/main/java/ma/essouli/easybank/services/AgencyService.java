package ma.essouli.easybank.services;

import ma.essouli.easybank.daoImp.AgencyDAOImp;

public class AgencyService {
    
    private static AgencyService instance = null;

    // dependencies
    private AgencyDAOImp agencyDAO = null;
    private AgencyAssignmentService agencyAssignmentService = null;
    private CreditRequestService creditRequestService = null;

    private AgencyService() {
        this.agencyDAO = AgencyDAOImp.getInstance();
        this.agencyAssignmentService = AgencyAssignmentService.getInstance();
        this.creditRequestService = CreditRequestService.getInsatnce();
    }

    public static AgencyService getInstance() {
        if( instance == null )
            instance = new AgencyService();
        return instance;
    }

}
