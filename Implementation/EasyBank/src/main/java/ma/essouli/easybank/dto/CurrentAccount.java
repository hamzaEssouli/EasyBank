package ma.essouli.easybank.dto;

import java.time.LocalDate;

import ma.essouli.easybank.enums.AccountStatus;

public class CurrentAccount extends Account {
    
    private float overdraft;

    public CurrentAccount(double balance, float overdraft, AccountStatus status, Client client, LocalDate creationDate) {
        setBalance(balance);
        setOverdraft(overdraft);
        setStatus(status);
        setClient(client); 
        setCreationDate(creationDate);  
    }

    public float getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(float overdraft) {
        this.overdraft = overdraft;
    }
    

    @Override
    public String toString() {
        return "{\n"+
        "\tAccount number: " + this.id + '\n'+
        "\tBalance : " + this.balance + '\n'+
        "\tStatus : " + this.status + '\n'+
        "\tOverdraft : " + this.overdraft +   "%\n"+
        "\tCreation date: " + this.creationDate + '\n'+
        "}";
    }
}
