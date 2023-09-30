package ma.essouli.easybank.controller;

import ma.essouli.easybank.dto.Mission;
import ma.essouli.easybank.services.MissionService;
import ma.essouli.easybank.view.MissionView;

public class MissionController {
    
    private static MissionController instance = null;

    private MissionService service = null;
    private MissionView view = null;

    private MissionController() {
        this.service = MissionService.getInstance();
        this.view = MissionView.getInstance();
    }

    public static MissionController getInstance() {
        if( instance == null )
            instance = new MissionController();
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
                this.display();
                break;
        }
    }

    private void display() {
    }

    private void create() {
        Mission mission = service.create( view.create() );
        if(mission != null ) 
            view.created(mission);
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

}
