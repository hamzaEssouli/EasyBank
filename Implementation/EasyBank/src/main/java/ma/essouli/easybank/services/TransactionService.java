package ma.essouli.easybank.services;

public class TransactionService {
    
    private static TransactionService instance = null;

    private TransactionService() {}

    public static TransactionService getInstance() {
        if( instance == null )
            instance = new TransactionService();
        return instance;
    }
}
