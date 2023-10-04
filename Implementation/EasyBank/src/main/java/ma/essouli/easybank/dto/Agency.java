package ma.essouli.easybank.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@AllArgsConstructor
@Data
@Builder
@ToString
public class Agency {
    
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    private List<AgencyAssignment> assignments;
    private List<CreditRequest> creditRequests;
}
