package ma.essouli.easybank.dto;

import java.time.LocalDate;
import java.util.List;

public class Employee extends Person {
    
    private LocalDate recruitmentDate;
    private String email;
    private List<Client> clients;
    private List<Operation> operations;
    private List<MissionAssignment> missions;

    public Employee() {};
    public Employee(String lastName, String firstName, LocalDate dateOfBirth, String phoneNUmber, LocalDate recruitmentDate, String email) {
        super(email, email, recruitmentDate, email);
        this.recruitmentDate = recruitmentDate;
        this.email = email;
    }
    public Employee(int id, String lastName, String firstName, LocalDate dateOfBirth, String phoneNUmber, LocalDate recruitmentDate, String email) {
        super(id, lastName, firstName, dateOfBirth ,phoneNUmber);
        this.recruitmentDate = recruitmentDate;
        this.email = email;
    }
    
    public LocalDate getRecruitmentDate() {
        return recruitmentDate;
    }
    public String getEmail() {
        return email;
    }
    public List<Client> getClients() {
        return clients;
    }
    public List<Operation> getOperations() {
        return operations;
    }
    public List<MissionAssignment> getMissions() {
        return missions;
    }

    public void setRecruitmentDate(LocalDate recruitmentDate) {
        this.recruitmentDate = recruitmentDate;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
    public void setMissions(List<MissionAssignment> missions) {
        this.missions = missions;
    }
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }


    @Override
    public String toString() {
        return 
            "{\n"+
            "\tRegistration number: " + this.getId() + '\n'+
            "\tLast name: " + this.getLastName() + '\n'+
            "\tFirst name: " + this.getFirstName() + '\n'+
            "\tDate of birth: " + this.getDateOfBirth() + '\n'+
            "\tPhone number: " + this.getPhoneNumber() + '\n'+
            "\tRecuitment date: " + this.getRecruitmentDate() + '\n'+
            "\tEmail: " + this.getEmail() + '\n'+
            '}'; 
    }

}
