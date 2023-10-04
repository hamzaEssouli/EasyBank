package ma.essouli.easybank.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public abstract class Operation {
    
    protected int id;
    protected LocalDateTime date;
    protected double amount;

    
}
