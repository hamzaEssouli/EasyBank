package ma.essouli.easybank.controller;

import java.util.List;

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
            case 2: 
                this.delete();
                break;
            case 3:
                this.searchByRegistrationCode();
                break;
            case 4:
                this.display();
                break;
            case 5:
                this.search();
                break;
            case 6:
                this.update();
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
        Client client = service.searchByRegistrationCode( view.searchByRegistrationCode() );
        byte choice = 0;
        if( client != null )
            choice = view.founded(client);
        else 
            view.notFounded();
        
        switch(choice) {
            case 0:
                this.main();
                break;
            case 1:
                // client accounts
            case 2:
                view.showClientAssistant( service.getEmployee( client.getEmployee().getId() ) );
                break;
        }

        this.main();
    }

    private void display() {
        view.DisplayClientsList( service.read() );
        this.main();
    }

    private void search() {
        List<Client> clients = service.search( view.search() );
        view.DisplayClientsList(clients);
        this.main();
    }

    private void update() {
        Client client = service.searchByRegistrationCode( view.edit() );
        if( client == null )
            view.notFounded();
        else    
            if(service.update( view.update(client) ) != null) 
                view.updated(client);
            else
                view.notUpdated();

        this.main(); 
    }

}
