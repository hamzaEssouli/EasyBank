package ma.essouli.easybank.services;

public class CreditRequestService {
    
    private static CreditRequestService instance = null;

    private CreditRequestService() {}

    public static CreditRequestService getInsatnce() {
        if( instance == null )
            instance = new CreditRequestService();
        return instance;
    }

}
