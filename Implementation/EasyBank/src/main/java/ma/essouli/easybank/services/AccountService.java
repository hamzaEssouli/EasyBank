package ma.essouli.easybank.services;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import ma.essouli.easybank.dao.AccountDAO;
import ma.essouli.easybank.daoImp.AccountDAOImp;
import ma.essouli.easybank.daoImp.CurrentAccountDAOImp;
import ma.essouli.easybank.daoImp.SavingAccountDAOImp;
import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.CurrentAccount;
import ma.essouli.easybank.dto.SavingAccount;
import ma.essouli.easybank.enums.AccountStatus;

public class AccountService {
    
    private AccountDAO accountDAO = null;
    private CurrentAccountDAOImp currentAccountDAOImp = null;
    private SavingAccountDAOImp savingAccountDAOImp = null;
    private static AccountService instance = null;

    private AccountService() {
        this.accountDAO = AccountDAOImp.getInstance();
        this.savingAccountDAOImp = SavingAccountDAOImp.getInstance();
        this.currentAccountDAOImp = CurrentAccountDAOImp.getInstance();
    }
    public static AccountService getInstance() {
        if( instance == null )
            instance = new AccountService();
        return instance;
    }



    public CurrentAccount createCurrentAccount(CurrentAccount currentAccount) {
        Optional<Account> account = accountDAO.create(currentAccount);
        if( ! account.isPresent() )
            return null;
        Optional<CurrentAccount> newAccount = currentAccountDAOImp.create(currentAccount);
        return newAccount.isPresent() ? 
            newAccount.get()
        :
            null;
    }

    public SavingAccount createSavingAccount(SavingAccount savingAccount) {
        Optional<Account> account = accountDAO.create(savingAccount);
        if( ! account.isPresent() )
            return null;
        Optional<SavingAccount> newAccount = savingAccountDAOImp.create(savingAccount);
        return newAccount.isPresent() ? 
            newAccount.get()
        :
            null;
    }

    public boolean delete(int accountId) {
        return accountDAO.delete(accountId);
    }

    public HashMap<String, List<?>> searchByClient(int clientId) {
        List<CurrentAccount> currentAccounts = currentAccountDAOImp.searchByClient(clientId);
        List<SavingAccount> savingAccounts = savingAccountDAOImp.searchByClient(clientId);

        HashMap<String, List<?>> accounts = new HashMap<>();
        accounts.put("currentAccounts", currentAccounts);
        accounts.put("savingAccounts", savingAccounts);

        return accounts;
    }

    public Account updateStatus(Account newAccount) {
        Optional<Account> account = accountDAO.update(newAccount);
        return account.isPresent() ?
            account.get()
        :
            null;

    }

    public List<Account> read() {
        return accountDAO.read();
    }

    public List<Account> displayByStatus(AccountStatus status) {
        return accountDAO.displayAccountsByStatus(status);
    }

    public List<Account> displayAccountsByCreationDate(LocalDate creationDate) {
        return accountDAO.displayAccountsByCreationDate(creationDate);
    }




    
}
