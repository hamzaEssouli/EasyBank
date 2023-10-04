package ma.essouli.easybank.dao;

import java.util.Optional;

import ma.essouli.easybank.dto.Agency;
import ma.essouli.easybank.dto.Employee;

public interface AgencyDAO extends Dao<Agency> { 

    Optional<Agency> getByEmployee(Employee employee);
    Optional<Agency> getByAddress(String address); 
}
