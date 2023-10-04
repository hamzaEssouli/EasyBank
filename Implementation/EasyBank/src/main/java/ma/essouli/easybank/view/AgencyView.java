package ma.essouli.easybank.view;

public class AgencyView {
    
    private static AgencyView instance = null;

    private AgencyView() {}

    public static AgencyView getInstance() {
        if( instance == null )
            instance = new AgencyView();
        return instance;
    }
}
