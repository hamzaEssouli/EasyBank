package ma.essouli.easybank.dto;

import java.time.LocalDate;

import ma.essouli.easybank.enums.AccountStatus;

public abstract class Account {
    
    private int id;
    private double balance;
    private LocalDate creationDate;
    private AccountStatus status;
    private Client client;

    public int getId() {
        return id;
    }
    public double getBalance() {
        return balance;
    }
    public LocalDate getCreationDate() {
        return creationDate;
    }
    public AccountStatus getStatus() {
        return status;
    }
    public Client getClient() {
        return client;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
    public void setStatus(AccountStatus status) {
        this.status = status;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    
}
