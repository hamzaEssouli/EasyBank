package ma.essouli.easybank.dao;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.CurrentAccount;

public interface CurrentAccountDAO {
    
    Optional<CurrentAccount> create(CurrentAccount account);
    Optional<CurrentAccount> update(CurrentAccount account);
    List<CurrentAccount> searchByClient(int clientId);
    List<CurrentAccount> searchByOperation(int operationId);
    
}
