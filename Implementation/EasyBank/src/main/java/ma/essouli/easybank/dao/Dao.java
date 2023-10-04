package ma.essouli.easybank.dao;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    
    Optional<T> create(T t);
    Optional<T> update(T t);
    List<T> read();
    boolean delete(int id);

}
