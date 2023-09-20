package ma.essouli.easybank.dto;

import java.time.LocalDate;
import java.util.List;

public class Employee extends Person {
    
    private LocalDate recruitmentDate;
    private String email;
    private List<Client> clients;
    private List<Operation> operations;
    private List<Mission> missions;
    
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
    public List<Mission> getMissions() {
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
    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }
    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

}
