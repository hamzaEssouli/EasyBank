package ma.essouli.easybank.controller;

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
            case 3:
                this.delete();
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

}
