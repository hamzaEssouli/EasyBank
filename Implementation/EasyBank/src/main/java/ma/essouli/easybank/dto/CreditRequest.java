package ma.essouli.easybank.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@Builder
@ToString
public class CreditRequest {
    
    private int id;
    private double amount;
    private int duration;
    private LocalDate date;

    private Client client;
    private Agency agency;
}
