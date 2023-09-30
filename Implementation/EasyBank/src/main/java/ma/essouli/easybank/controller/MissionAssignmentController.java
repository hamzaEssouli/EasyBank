package ma.essouli.easybank.controller;

import ma.essouli.easybank.dto.MissionAssignment;
import ma.essouli.easybank.services.MissionAssignementService;
import ma.essouli.easybank.view.MissionAssignementView;

public class MissionAssignmentController {
    
    private static MissionAssignmentController instance = null;

    private MissionAssignementService service = null;
    private MissionAssignementView view = null;
    
    private MissionAssignmentController() {
        this.service = MissionAssignementService.getInstance();
        this.view = MissionAssignementView.getInstance();
    }

    public static MissionAssignmentController getInstance() {
        if( instance == null )
            instance = new MissionAssignmentController();
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
                break;
            case 3:
                break;
        }
    }

    private void create() {
        MissionAssignment assignment = service.create( view.create() );
        if(assignment != null)
            view.created(assignment);
        else view.notCreated();
        
        this.main();
    }
}
