package ma.essouli.easybank.dto;

import java.time.LocalDate;


public class MissionAssignment {
    
    private int id;
    private LocalDate assignmentStartDate;
    private LocalDate assignmentEndDate;
    private Mission mission;
    private Employee employee;

    public int getId() {
        return id;
    }
    public LocalDate getAssignmentStartDate() {
        return assignmentStartDate;
    }
    public LocalDate getAssignmentEndDate() {
        return assignmentEndDate;
    }
    public Employee getEmployee() {
        return employee;
    }
    public Mission getMission() {
        return mission;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setAssignmentStartDate(LocalDate assignmentStartDate) {
        this.assignmentStartDate = assignmentStartDate;
    }
    public void setAssignmentEndDate(LocalDate assignmentEndDate) {
        this.assignmentEndDate = assignmentEndDate;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void setMission(Mission mission) {
        this.mission = mission;
    }
}
