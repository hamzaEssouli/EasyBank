package ma.essouli.easybank.dto;

import java.time.LocalDate;


public abstract class Person {
    
    private int id;
    private String lastName;
    private String firstName;
    private LocalDate dateOfBirth;
    private String phoneNumber;


    public int getId() {
        return this.id;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getFirstName() {
        return this.firstName;
    }
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
