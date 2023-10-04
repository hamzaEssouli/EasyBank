package ma.essouli.easybank.controller;

import ma.essouli.easybank.services.CreditRequestService;
import ma.essouli.easybank.view.CreditRequestView;

public class CreditRequestController {
    
    private static CreditRequestController instance = null;

    // dependencies
    private CreditRequestView view = null;
    private CreditRequestService service = null;

    private CreditRequestController() {
        this.view = CreditRequestView.getInstance();
        this.service = CreditRequestService.getInstance(); 
    }

    public static CreditRequestController getInstance() {
        if( instance == null )
            instance = new CreditRequestController();
        return instance;
    }
}
