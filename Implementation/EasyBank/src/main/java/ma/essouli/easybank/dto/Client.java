package ma.essouli.easybank.dto;

import java.time.LocalDate;
import java.util.List;

public class Client extends Person {
     
    private String address;
    private Employee employee;
    private List<Account> accounts;

    public Client(){}
    public Client(String lastName, String firstName, LocalDate dateOfBirth, String phoneNumber, String address, int employeeId) {
        super(lastName, firstName, dateOfBirth, phoneNumber);
        this.address = address;
        this.employee = new Employee();
        this.employee.setId(employeeId);
    }
    public Client(int id, String lastName, String firstName, LocalDate dateOfBirth, String phoneNumber, String address) {
        super(id, lastName, firstName, dateOfBirth ,phoneNumber);
        this.address = address;
    }

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


    @Override
    public String toString() {
        return 
            "{\n"+
            "\tCode: " + this.getId() + '\n'+
            "\tLast name: " + this.getLastName() + '\n'+
            "\tFirst name: " + this.getFirstName() + '\n'+
            "\tDate of birth: " + this.getDateOfBirth() + '\n'+
            "\tPhone number: " + this.getPhoneNumber() + '\n'+
            "\tAddress: " + this.getAddress() + '\n'+
            '}'; 
    }
}
