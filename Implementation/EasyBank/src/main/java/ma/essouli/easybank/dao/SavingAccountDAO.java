package ma.essouli.easybank.dao;

import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.SavingAccount;

public interface SavingAccountDAO {
    
    Optional<SavingAccount> create(SavingAccount account);
    Optional<SavingAccount> update(SavingAccount account);
    Optional<SavingAccount> find(int accountId);
    List<SavingAccount> searchByClient(int clientId);
    List<SavingAccount> searchByOperation(int operationId);
}
