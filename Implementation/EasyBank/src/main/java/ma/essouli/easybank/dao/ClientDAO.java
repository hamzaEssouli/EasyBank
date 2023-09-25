package ma.essouli.easybank.dao;

import java.util.Optional;

import ma.essouli.easybank.dto.Client;

public interface ClientDAO extends Dao<Client> {
    
    Optional<Client> search(String attribute);
    Optional<Client> searchById(int id);

}
