package ma.essouli.easybank.controller;

import java.util.HashMap;
import java.util.List;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.CurrentAccount;
import ma.essouli.easybank.dto.SavingAccount;
import ma.essouli.easybank.services.AccountService;
import ma.essouli.easybank.view.AccountView;

public class AccountController {
    
    private AccountView view = null;
    private AccountService service = null;
    
    private static AccountController instance = null;

    private AccountController() {
        this.view = AccountView.getInstance();
        this.service = AccountService.getInstance();
    }

    public static AccountController getInstance() {
        if( instance == null )
            instance = new AccountController();
        return instance;
    }

    public void main() {
        byte choice = view.menu(); 
        switch( choice ) {
            case 0:
                MainController.main();
                break;
            case 1:
                this.create();
                break;
            case 2:
                this.updateStatus();
                break;
            case 3:
                this.delete();
                break;
            case 4:
                this.searchByRegistrationCode();
                break;
            case 6:
                this.display();
                break;
                
            
        }
    }
    
    private void create() {
        switch(view.create()) {
            case 1:
                CurrentAccount currentAccount = service.createCurrentAccount( view.createCurrentAccount());
                if (currentAccount == null)
                    view.notCreated();
                else
                    view.currentAccountCreated(currentAccount);
                break;
            case 2:
                SavingAccount savingAccount = service.createSavingAccount( view.createSavingAccount() );
                if(savingAccount == null )
                    view.notCreated();
                else 
                    view.savingAccountCreated(savingAccount);
                
        }
        this.main();
    }

    private void delete() {
        int id = view.delete();
        if(id != 0) { 
            if( service.delete(id) ) 
                view.deleted(id);     
            else 
                view.notDeleted();
        } 
        this.main();
    }

    private void searchByRegistrationCode() {
        HashMap<String, List<?>> accounts = service.searchByClient( view.searchByClient() );
        view.founded(accounts);
        this.main();
    }

    private void updateStatus() {
        Account account = new Account();
        account.setId( view.edit() );
        account.setStatus( view.update(account) );
        if( service.updateStatus(account) == null ) 
            view.notUpdated();
        else view.updated(account);

        this.main();
    }

    private void display() {
        byte choice = view.display();
        switch(choice) {
            case 1:
                view.DisplayAccountsList( service.read() );
                break;
            case 2:
                view.DisplayAccountsList( service.displayByStatus( view.getStatus() ) );
                break;
            case 3:
                view.DisplayAccountsList( service.displayAccountsByCreationDate( view.getDate() ) );
        }
        
        this.main();
    }


}
