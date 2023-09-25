package ma.essouli.easybank.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.enums.AccountStatus;

public interface AccountDAO extends Dao<Account>{

    List<Account> searchByClient(int clientId);
    Optional<Account> searchByOperationId(int operationId);
    List<Account> displayByStatus(AccountStatus status);
    List<Account> displayByCreationDate(LocalDate creationDate);

}
