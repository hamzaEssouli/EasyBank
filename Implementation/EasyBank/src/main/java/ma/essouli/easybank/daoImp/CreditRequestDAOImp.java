package ma.essouli.easybank.daoImp;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.CreditRequestDAO;
import ma.essouli.easybank.dto.CreditRequest;
import ma.essouli.easybank.enums.CreditRequestStatus;

public class CreditRequestDAOImp implements CreditRequestDAO {

    private static CreditRequestDAOImp instance = null;

    // dependencies
    private AgencyDAOImp agencyDAO = null;
    private ClientDAOImp clientDAO = null;

    private CreditRequestDAOImp() {
        this.agencyDAO = AgencyDAOImp.getInstance();
        this.clientDAO = ClientDAOImp.getInstance();
    }

    public static CreditRequestDAOImp getInstance() {
        if( instance == null )
            instance = new CreditRequestDAOImp();
        return instance;
    }

    @Override
    public Optional<CreditRequest> create(CreditRequest creditRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Optional<CreditRequest> update(CreditRequest creditRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<CreditRequest> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int creditRequestId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<CreditRequest> getByClient(int clientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByClient'");
    }

    @Override
    public List<CreditRequest> getByAgency(int agencyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByAgency'");
    }

    @Override
    public List<CreditRequest> getBydate(LocalDate date) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBydate'");
    }

    @Override
    public List<CreditRequest> getByStatus(CreditRequestStatus status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByStatus'");
    }
    
}
