package ma.essouli.easybank.dto;

import java.time.LocalDate;
import java.util.List;

import ma.essouli.easybank.enums.AccountStatus;

public abstract class Account {
    
    protected int id;
    protected double balance;
    protected LocalDate creationDate;
    protected AccountStatus status;
    protected Client client;
    protected List<Operation> operations; 

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
    public List<Operation> getOperations() {
        return operations;
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
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }


    
}
