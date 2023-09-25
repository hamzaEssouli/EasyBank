package ma.essouli.easybank.view;

import java.time.LocalDate;
import java.util.Scanner;

import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.CurrentAccount;
import ma.essouli.easybank.dto.SavingAccount;
import ma.essouli.easybank.enums.AccountStatus;

public class AccountView {
    
    private static AccountView instance = null;
    private Scanner scanner = null;

    private AccountView(){
        this.scanner = new Scanner(System.in);
    }

    public static AccountView getInstance() {
        if( instance == null )
            instance = new AccountView();
        return instance;
    }

    public byte menu() {
        byte choice = -1;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Accounts menu**********************************");
            System.out.println("1 - Add");
            System.out.println("2 - update ");
            System.out.println("3 - Delete");
            System.out.println("4 - search");
            System.out.println("5 - update account status");
            System.out.println("6 - display accounts");
            System.out.println("0 - back to main menu");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextByte();
            } catch (Exception e) {
                scanner.next();
            }
        } while( choice < 0 || choice > 7);

        return choice;
    }


    public byte create() {
        byte choice = -1;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Create new account**********************************");
            System.out.println("1 - Current account");
            System.out.println("2 - Saving account");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextByte();
            } catch (Exception e) {
                scanner.next();
            }
        } while( choice < 0 || choice > 2);

        return choice;
    }

    public CurrentAccount createCurrentAccount() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Add current account**********************************");
        System.out.print("Client ");
        int clientId = getId("client");
        double balance = getBalance();
        AccountStatus status = getStatus();
        float overdraft = getOverdraft();
        Client client = new Client();
        client.setId(clientId);
        return new CurrentAccount(balance, overdraft, status, client);
    }

    public SavingAccount createSavingAccount() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Add saving account**********************************");
        System.out.print("Client ");
        int clientId = getId("client");
        double balance = getBalance();
        AccountStatus status = getStatus();
        float intrestRate = getInterestRate();
        Client client = new Client();
        client.setId(clientId);
        return new SavingAccount(balance, intrestRate, status, client, LocalDate.now());
    }

    public void currentAccountCreated(CurrentAccount account) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Account added succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(account);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void savingAccountCreated(SavingAccount account) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Account added succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(account);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notCreated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Account couldn't be added**********************************");
            System.out.println("\n\n");
            System.out.println("check your inputs and try again");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }

    


    private int getId(String lable) {
        int id = -1;
        boolean valid = false;
        String answer = "";
        do {
            try {
                System.out.print("registration code: ");
                id = scanner.nextInt();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid );
        if( lable.equals("delete") ) {
            scanner.nextLine();
            do {
                try {
                    System.out.println("Are u realy want to delete the employee with that registration code ? [yes/no]");
                    answer = scanner.nextLine().toLowerCase();
                } catch (Exception e) { scanner.next(); }
            } while(  ! answer.equals("yes")  &&  ! answer.equals("no") || answer.equals("")  );
            if( answer.compareTo("no") == 0 ) 
                id = 0;
        }

        return id;
    }

    private double getBalance() {
        double balance = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Balance: ");
                balance = scanner.nextDouble();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid || balance < 0  );
        return balance;
    }

    private float getOverdraft() {
        float overdraft = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Overdraft: ");
                overdraft = scanner.nextFloat();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid || overdraft < 0  );
        return overdraft;
    }

    private float getInterestRate() {
        float overdraft = 0;
        boolean valid = false;
        do {
            try {
                System.out.print("Interest Rate: ");
                overdraft = scanner.nextFloat();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid || overdraft < 0  );
        return overdraft;
    }

    private AccountStatus getStatus() {
        AccountStatus status = AccountStatus.ACTIVE;
        byte choice = -1;
        System.out.println("Status");
        System.out.println("1 - ACTIVE");
        System.out.println("2 - FROZEN");
        System.out.println("3 - CLOSED");
        do{
            try{
                System.out.print("\nchoice: ");
                choice = scanner.nextByte();
            } catch( Exception e) { scanner.next(); }
        } while(choice < 1 || choice > 3 );
        switch(choice) {
            case 1:
                status = AccountStatus.ACTIVE;
                break;
            case 2:
                status = AccountStatus.FROZEN;
                break;
            case 3:
                status = AccountStatus.CLOSED;
                break;
        }
        return status;
    }
}
