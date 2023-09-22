package ma.essouli.easybank.controller;

import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.services.EmployeeService;
import ma.essouli.easybank.view.EmployeeView;

public class EmployeeController {
    
    private EmployeeView view = null;
    private EmployeeService service = null;
    private static EmployeeController instance = null;

    private EmployeeController() {
        this.view = EmployeeView.getInstance();
        this.service = EmployeeService.getInstance();
    }

    public static EmployeeController getInstance() {
        if( instance == null )
            instance = new EmployeeController();
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
            default:
                this.main();
        }
    }

    private void create() {
        Employee employee = service.create( view.create() );
        if( employee != null )
            view.created(employee);
        this.main();
    }

    private void delete() {
        int id = view.delete();
        if(id != 0) { 
            if( service.delete(id) == false ) 
                view.notDeleted();
            else 
                view.deleted(id);     
        } 
        this.main();
    }
}
