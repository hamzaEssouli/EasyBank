package ma.essouli.easybank.dao;


import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.enums.AccountStatus;


public interface AccountDAO extends Dao<Account> {
    
    Optional<Account> show(int accountId);
    List<Account> displayAccountsByStatus(AccountStatus status);

}
