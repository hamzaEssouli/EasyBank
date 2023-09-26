package ma.essouli.easybank.dto;

import java.time.LocalDate;

import ma.essouli.easybank.enums.AccountStatus;

public class SavingAccount extends Account {
    
    private double interestRate;

    public SavingAccount() {}
    public SavingAccount(double balance, float interestRate, AccountStatus status, Client client, LocalDate creationDate) {
        setBalance(balance);
        setInterestRate(interestRate);
        setStatus(status);
        setClient(client);
        setCreationDate(creationDate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
    

    @Override
    public String toString() {
        return "\n{\n"+
        "\tAccount number: " + this.id + '\n'+
        "\tBalance : " + this.balance + '\n'+
        "\tStatus : " + this.status + '\n'+
        "\tInterest rate : " + this.interestRate +   "%\n"+
        "\tCreation date: " + this.creationDate + '\n'+
        "}\n";
    }
}
