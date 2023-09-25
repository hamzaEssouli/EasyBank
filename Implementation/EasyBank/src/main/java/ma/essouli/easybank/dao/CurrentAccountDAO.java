package ma.essouli.easybank.dao;

import java.util.Optional;

import ma.essouli.easybank.dto.CurrentAccount;

public interface CurrentAccountDAO {
    
    Optional<CurrentAccount> create(CurrentAccount account);
    Optional<CurrentAccount> update(CurrentAccount account);
    
}
