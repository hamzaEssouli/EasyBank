package ma.essouli.easybank.dto;

import java.time.LocalDate;

import ma.essouli.easybank.enums.OperationType;

public class Operation {
    
    private int id;
    private LocalDate date;
    private double amount;
    private OperationType type;
    private Account account;
    private Employee employee;

    public int getId() {
        return id;
    }
    public LocalDate getDate() {
        return date;
    }
    public double getAmount() {
        return amount;
    }
    public OperationType getType() {
        return type;
    }
    public Account getAccount() {
        return account;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setType(OperationType type) {
        this.type = type;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void setAccount(Account account) {
        this.account = account;
    }

}
