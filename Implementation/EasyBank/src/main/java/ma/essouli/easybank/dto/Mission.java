package ma.essouli.easybank.dto;

import java.util.List;

public class Mission {
    
    private int id;
    private String name;
    private String description;
    private List<MissionAssignment> history;

    public Mission(){}
    public Mission(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Mission(int id, String name, String description, List<MissionAssignment> history) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.history = history;
    }


    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public List<MissionAssignment> getHistory() {
        return history;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setHistory(List<MissionAssignment> history) {
        this.history = history;
    }


    @Override
    public String toString() {
        return "{\n" + 
        "\tId: " + this.id + '\n' +
        "\tName: " + this.name + '\n' +
        "\tDescription: " + this.description + '\n' +
        "}";
    }

}
