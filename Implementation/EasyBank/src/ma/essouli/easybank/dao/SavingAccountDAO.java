package ma.essouli.easybank.dao;

import java.util.Optional;

import ma.essouli.easybank.dto.SavingAccount;

public interface SavingAccountDAO {
    
    Optional<SavingAccount> create(SavingAccount account);
    Optional<SavingAccount> update(SavingAccount account);
    
}
