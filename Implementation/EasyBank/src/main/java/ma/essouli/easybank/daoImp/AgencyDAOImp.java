package ma.essouli.easybank.daoImp;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.AgencyDAO;
import ma.essouli.easybank.dto.Agency;
import ma.essouli.easybank.dto.Employee;

public class AgencyDAOImp implements AgencyDAO {
    
    private static AgencyDAOImp instance = null;

    private AgencyDAOImp() {}

    public static AgencyDAOImp getInstance() {
        if( instance == null )
            instance = new AgencyDAOImp();
        return instance;
    }

    @Override
    public Optional<Agency> create(Agency agenct) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public Optional<Agency> update(Agency agency) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Agency> read() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'read'");
    }

    @Override
    public boolean delete(int agencyId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Optional<Agency> getByEmployee(Employee employee) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByEmployee'");
    }

    @Override
    public Optional<Agency> getByAddress(String address) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByAddress'");
    }
    
}
