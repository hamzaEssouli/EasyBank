package ma.essouli.easybank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Transaction extends Operation {
    
    private Account srcAccount;
    private Account dstAccount;

}
