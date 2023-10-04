package ma.essouli.easybank.dao;

import java.time.LocalDate;
import java.util.List;

import ma.essouli.easybank.dto.CreditRequest;
import ma.essouli.easybank.enums.CreditRequestStatus;

public interface CreditRequestDAO extends Dao<CreditRequest> {
    
    List<CreditRequest> getByClient(int clientId);
    List<CreditRequest> getByAgency(int agencyId);
    List<CreditRequest> getBydate(LocalDate date);
    List<CreditRequest> getByStatus(CreditRequestStatus status);
}
