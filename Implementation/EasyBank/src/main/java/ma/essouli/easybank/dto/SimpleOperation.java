package ma.essouli.easybank.dto;


import ma.essouli.easybank.enums.OperationType;


public class SimpleOperation extends Operation {
    
    private OperationType type;
    private Account account;
    private Employee employee;


    public OperationType getType() {
        return type;
    }
    public Account getAccount() {
        return account;
    }
    public Employee getEmployee() {
        return employee;
    }

    public void setType(OperationType type) {
        this.type = type;
    }
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public void setAccount(Account account) {
        this.account = account;
    }


    @Override
    public String toString() {
        return "{\n"+
            "\tType: " + this.type.toString() + '\n' +
            "\tAmount: " + this.amount + '\n' +
            "\tDate: " + this.date.toString() + '\n'+
            "\tAccount :"  +  this.account +'\n'+
            "}";
    }
}
