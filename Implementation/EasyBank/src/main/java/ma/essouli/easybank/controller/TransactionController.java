package ma.essouli.easybank.controller;

import ma.essouli.easybank.services.TransactionService;
import ma.essouli.easybank.view.TransactionView;

public class TransactionController {
    
    private static TransactionController instance = null;

    // dependencies
    private TransactionView view = null;
    private TransactionService service = null;

    private TransactionController() {
        this.view = TransactionView.getInstance();
        this.service = TransactionService.getInstance(); 
    }

    public static TransactionController getInstance() {
        if( instance == null )
            instance = new TransactionController();
        return instance;
    }

}
