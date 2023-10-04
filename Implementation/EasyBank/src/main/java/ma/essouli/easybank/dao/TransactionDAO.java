package ma.essouli.easybank.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TransactionDAO {
    
    Optional<TransactionDAO> create(TransactionDAO transaction);
    boolean delete(int transactionId);
    Optional<TransactionDAO> find(int transactionId );
    List<TransactionDAO> getByAccount(int accountId);
    List<TransactionDAO> getByDate(LocalDate date);
}
