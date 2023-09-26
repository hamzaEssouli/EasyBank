package ma.essouli.easybank.services;

import java.util.Optional;

import ma.essouli.easybank.dao.AccountDAO;
import ma.essouli.easybank.daoImp.AccountDAOImp;
import ma.essouli.easybank.daoImp.CurrentAccountDAOImp;
import ma.essouli.easybank.daoImp.SavingAccountDAOImp;
import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.CurrentAccount;
import ma.essouli.easybank.dto.SavingAccount;

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

}
