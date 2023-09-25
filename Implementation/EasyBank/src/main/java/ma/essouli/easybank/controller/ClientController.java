package ma.essouli.easybank.controller;

import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.services.ClientService;
import ma.essouli.easybank.view.ClientView;


public class ClientController {
    private ClientView view = null;
    private ClientService service = null;
    private static ClientController instance = null;

    private ClientController() {
        this.view = ClientView.getInstance();
        this.service = ClientService.getInstance();
    }

    public static ClientController getInstance() {
        if( instance == null )
            instance = new ClientController();
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
        }
    }

    private void create() {
        Client client = service.create( view.create() );
        if( client != null )
            view.created(client);
        else view.notCreated();
        this.main();
    }

}
