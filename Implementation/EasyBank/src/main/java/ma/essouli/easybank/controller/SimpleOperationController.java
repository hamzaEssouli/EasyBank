package ma.essouli.easybank.controller;

import ma.essouli.easybank.dto.SimpleOperation;
import ma.essouli.easybank.services.SimpleOperationService;
import ma.essouli.easybank.view.OperationView;

public class SimpleOperationController {
    
    private static SimpleOperationController instance = null;
    
    private  SimpleOperationService service = null;
    private OperationView view = null;

    private SimpleOperationController() {
        service = SimpleOperationService.getInstance();
        view = OperationView.getInstance();
    }

    public static SimpleOperationController getInstance() {
        if( instance == null )
            instance = new SimpleOperationController();
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
                this.search();
                break;
        }
    }

    

    private void create() {
        SimpleOperation operation = service.create( view.create() );
        if(operation == null) 
            view.notCreated();
        else view.created(operation);

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

    private void search() {
        SimpleOperation operation = service.search( view.search() );
        if( operation == null )
            view.notFounded();
        else view.founded(operation);

        this.main();
    }

    
}
