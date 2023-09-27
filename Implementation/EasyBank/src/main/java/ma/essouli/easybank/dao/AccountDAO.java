package ma.essouli.easybank.dao;


import java.util.Optional;

import ma.essouli.easybank.dto.Account;


public interface AccountDAO extends Dao<Account> {
    
    Optional<Account> show(int accountId);

}
