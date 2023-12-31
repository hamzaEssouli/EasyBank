package ma.essouli.easybank.dao;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.enums.AccountStatus;


public interface AccountDAO extends Dao<Account> {
    
    Optional<Account> update(Account account);
    Optional<Account> find(int accountId);
    List<Account> displayAccountsByStatus(AccountStatus status);
    List<Account> displayAccountsByCreationDate(LocalDate creationDate);
    Optional<Account> findByOperation(int operationId);

}
