package ma.essouli.easybank.view;

import java.util.Scanner;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.dto.Operation;
import ma.essouli.easybank.enums.OperationType;

public class OperationView {
    
    private static OperationView instance = null;
    
    private Scanner scanner = null;
    
    private OperationView() {
        this.scanner = new Scanner(System.in);
    }

    public static OperationView getInstance() {
        if( instance == null )
            instance = new OperationView();
        return instance;
    }

    public byte menu() {
        byte choice = -1;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Operation menu**********************************");
            System.out.println("1 - Add");
            System.out.println("2 - Delete");
            System.out.println("3 - search by code");
            System.out.println("0 - back to main menu");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextByte();
            } catch (Exception e) {
                scanner.next();
            }
        } while( choice < 0 || choice > 6);

        return choice;
    }

    public Operation create() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Add operation**********************************");
        System.out.print("Account ");
        int accountId = getId("account");
        System.out.print("Employee ");
        int employeeId = getId("employee");
        double amount = getAmount();
        OperationType type = getType();

        Operation operation = new Operation();
        Employee employee = new Employee();
        Account account = new Account();
        account.setId(accountId);
        employee.setId(employeeId);
        operation.setAmount(amount);
        operation.setType(type);
        operation.setAccount(account);
        operation.setEmployee(employee);
        
        return operation;

    }

    public void created(Operation operation) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Operation added succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(operation);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notCreated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Operation couldn't be added**********************************");
            System.out.println("\n\n");
            System.out.println("Insufficient funds for withdrawal, Or wrong inputs");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }

    public int delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Delete operation**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("delete");
        return id;
    }

    public void deleted(int id) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Operation deleted succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println("Operation with code ( "+id+" ) deleted.");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notDeleted() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Operation couldn't be deleted**********************************");
            System.out.println("\n\n");
            System.out.println("Try again.");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }

    public int search() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Search operation**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("search");
        return id;
    }
    
    public void founded(Operation operation) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Operation founded succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(operation);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notFounded() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Operation not founded**********************************");
            System.out.println("\n\n");
            System.out.println("There is no operation with those credentials.");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }  
    }




    private int getId(String lable) {
        int id = -1;
        boolean valid = false;
        String answer = "";
        do {
            try {
                System.out.print("code: ");
                id = scanner.nextInt();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid );
        if( lable.equals("delete") ) {
            scanner.nextLine();
            do {
                try {
                    System.out.println("Do u realy want to delete the operation with that  code ? [yes/no]");
                    answer = scanner.nextLine().toLowerCase();
                } catch (Exception e) { scanner.next(); }
            } while(  ! answer.equals("yes")  &&  ! answer.equals("no") || answer.equals("")  );
            if( answer.compareTo("no") == 0 ) 
                id = 0;
        }

        return id;
    }

    private double getAmount() {
        double balance = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Amount: ");
                balance = scanner.nextDouble();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid || balance < 0  );
        return balance;
    }

     public OperationType getType() {
        OperationType type = null;
        byte choice = -1;
        System.out.println("Type ");
        System.out.println("1 - WITHDRAWAL");
        System.out.println("2 - DIPOSIT");
        do{
            try{
                System.out.print("\nchoice: ");
                choice = scanner.nextByte();
            } catch( Exception e) { scanner.next(); }
        } while(choice < 1 || choice > 2 );
        switch(choice) {
            case 1:
                type = OperationType.WITHDRAWAL;
                break;
            case 2:
                type = OperationType.DIPOSIT;
                break;
        }
        return type;
    }
}
