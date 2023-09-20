package ma.essouli.easybank.dto;

import java.util.List;

public class Client extends Person {
     
    private String address;
    private Employee employee;
    private List<Account> accounts;

    public String getAddress() {
        return address;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
