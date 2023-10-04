package ma.essouli.easybank.controller;

import ma.essouli.easybank.services.AgencyService;
import ma.essouli.easybank.view.AgencyView;

public class AgencyController {
    
    private static AgencyController instance = null;

    // dependencies
    private AgencyView view = null;
    private AgencyService service = null;

    private AgencyController() {
        this.view = AgencyView.getInstance();
        this.service = AgencyService.getInstance(); 
    }

    public static AgencyController getInstance() {
        if( instance == null )
            instance = new AgencyController();
        return instance;
    }

     
}
