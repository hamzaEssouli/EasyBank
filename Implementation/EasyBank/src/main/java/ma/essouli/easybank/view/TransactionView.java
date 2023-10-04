package ma.essouli.easybank.view;

public class TransactionView {
    
    private static TransactionView instance = null;

    private TransactionView() {}

    public static TransactionView getInstance() {
        if( instance == null )
            instance = new TransactionView();
        return instance;
    }
}
