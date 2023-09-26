package ma.essouli.easybank.dao;


import java.util.Optional;

import ma.essouli.easybank.dto.Account;


public interface AccountDAO {
    Optional<Account> create(Account account);
    Optional<Account> updateStatus(Account account);
    Optional<Account> show(int accountId);
    boolean delete(int accountId);

}
