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
            case 1:
                this.create();
                break;
        }
    }

    private void create() {
        Employee employee = service.create( view.create() );
        if( employee != null )
            view.created(employee);
    }
}
