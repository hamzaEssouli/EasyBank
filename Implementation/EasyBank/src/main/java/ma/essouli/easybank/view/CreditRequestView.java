package ma.essouli.easybank.view;

public class CreditRequestView {
    
    private static CreditRequestView instance = null;

    private CreditRequestView() {}

    public static CreditRequestView getInstance() {
        if( instance == null )
            instance = new CreditRequestView();
        return instance;
    }
}
