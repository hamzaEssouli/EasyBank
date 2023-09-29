package ma.essouli.easybank.controller;

import ma.essouli.easybank.dto.Operation;
import ma.essouli.easybank.services.OperationService;
import ma.essouli.easybank.view.OperationView;

public class OperationController {
    
    private static OperationController instance = null;
    
    private  OperationService service = null;
    private OperationView view = null;

    private OperationController() {
        service = OperationService.getInstance();
        view = OperationView.getInstance();
    }

    public static OperationController getInstance() {
        if( instance == null )
            instance = new OperationController();
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
                this.delete();
                break;
            case 3:
                this.searchByCode();
                break;
        }
    }

    private void searchByCode() {
    }

    private void delete() {
    }

    private void create() {
        Operation operation = service.create( view.create() );
        if(operation == null) 
            view.notCreated();
        else view.created(operation);

        this.main();
    }

    
}
