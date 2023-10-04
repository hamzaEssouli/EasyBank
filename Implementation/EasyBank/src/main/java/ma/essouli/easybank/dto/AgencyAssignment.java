package ma.essouli.easybank.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class AgencyAssignment {
    
    private LocalDate startDate;
    private LocalDate endDate;
    private Agency agency;
    private Employee employee;
    
}
