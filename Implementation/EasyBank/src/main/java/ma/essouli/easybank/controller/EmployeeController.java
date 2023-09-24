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
            case 3: 
                this.searchByRegistrationCode();
                break;
            case 4:
                this.display();
                break;
            default:
                this.main();
        }
    }

    private void create() {
        Employee employee = service.create( view.create() );
        if( employee != null )
            view.created(employee);
        else view.notCreated();
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
        Employee employee = service.searchByRegistrationCode( view.searchByRegistrationCode() );
        byte choice = 0;
        if( employee != null )
            choice = view.founded(employee);
        else 
            view.notFounded();
        
        switch(choice) {
            case 0:
                this.main();
                break;
            case 1:
                view.showEmployeeClients( service.getClients(employee.getId()) );
                break;
            case 2:
                view.showEmployeeMissionAssignments( service.getMissionAssignments( employee.getId() ) );
                break;
            case 3:
                view.showEmployeeOperations( service.getOperations( employee.getId() ) );
                break;
        }

        this.main();
    }


    private void display() {
        view.DisplayEmployeesList( service.read() );
        this.main();
    }

    private void update() {
        service.searchByRegistrationCode( view.edit() );
        
    }
}
