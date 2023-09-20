package ma.essouli.easybank.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.enums.AccountStatus;

public interface AccountDAO {

    int delete(int accountid);
    List<Account> searchByClient(Client client);
    Optional<Account> searchByOperationId(int operationId);
    List<Account> displayByStatus(AccountStatus status);
    List<Account> displayByCreationDate(LocalDate creationDate);

}
