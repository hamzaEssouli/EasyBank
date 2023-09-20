package ma.essouli.easybank.dto;

import java.util.List;

public class Mission {
    
    private int id;
    private String name;
    private String description;
    private List<MissionAssignment> history;

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

}
