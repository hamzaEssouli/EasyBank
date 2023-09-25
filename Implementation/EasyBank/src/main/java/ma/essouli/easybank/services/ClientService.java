package ma.essouli.easybank.services;

import java.util.Optional;

import ma.essouli.easybank.daoImp.ClientDAOImp;
import ma.essouli.easybank.dto.Client;


public class ClientService {

    private ClientDAOImp clientDAO = null;
    private static ClientService instance = null;

    private ClientService() {
        this.clientDAO = ClientDAOImp.getInstance();
    }
    public static ClientService getInstance() {
        if( instance == null )
            instance = new ClientService();
        return instance;
    }

    public Client create(Client client) {
        Optional<Client> optionalClient = clientDAO.create(client);
        return optionalClient.isPresent() ? 
            optionalClient.get()
        :
            null;
    }

    public boolean delete(int id) {
        return clientDAO.delete(id);
    }
}
