package ma.essouli.easybank.view;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import ma.essouli.easybank.dto.Account;
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
            System.out.println("5 - update");
            System.out.println("6 - display");
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
        return new CurrentAccount(balance, overdraft, status, client, LocalDate.now());
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

    
    public int delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Delete account**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("delete");
        return id;
    }
    public void deleted(int id) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Account deleted succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println("Account with  number ( "+id+" ) deleted.");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    public void notDeleted() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Account couldn't be deleted**********************************");
            System.out.println("\n\n");
            System.out.println("Account not exist");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }


    public int searchByClient() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Search Account by client**********************************");
        System.out.println("(0): Back to main menu");
        System.out.print("Client ");
        int id = getId("search");
        return id;
    }

    public void founded(HashMap< String, List<?>> accounts) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Account founded succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println("Current accounts \n\n\n");
        if( ! accounts.get("currentAccounts").isEmpty() )
            System.out.println(accounts.get("currentAccounts").toString() );
        else System.out.println("No current Accounts");
        System.out.println("\n\n\n\n");
        System.out.println("Saving accounts \n\n\n");
        if( ! accounts.get("savingAccounts").isEmpty() )
            System.out.println(accounts.get("savingAccounts").toString());
        else System.out.println("No saving Accounts");
        System.out.println("\n\n\n\n");

        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notFounded() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Account not founded**********************************");
            System.out.println("\n\n");
            System.out.println("There is no Account with those credentials.");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }  
    }

    public int[] edit() {
        int[] accountWithUpdateChoice = new int[2];
        int choice = -1;
        int accountId = 0;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Update account**********************************");
        accountId = getId("update");
        System.out.println("1 - update account balance");
        System.out.println("2 - Update account status");
        System.out.println("3 - Update account overdraft");
        System.out.println("4 - Update account interest rate");
        do{
            try{
                System.out.print("Enter your choice: ");
                choice = scanner.nextByte();
            } catch(Exception e) { scanner.next(); }
        } while( choice < 1 || choice > 4 );
        
        accountWithUpdateChoice[0] = accountId;
        accountWithUpdateChoice[1] = choice;
        
        return accountWithUpdateChoice;
    }



    

    public Account updateBalance(Account account) {
        scanner.nextLine();
        System.out.println(account);
        System.out.println("\n\n\n");
        
        account.setBalance(getBalance());

        return account;
    }

    public Account updateStatus(Account account) {
        scanner.nextLine();
        System.out.println(account);
        System.out.println("\n\n\n");
        
        account.setStatus(getStatus());
        
        return account;
    }

    public CurrentAccount updateOverdraft(CurrentAccount account) {
        scanner.nextLine();
        System.out.println(account);
        System.out.println("\n\n\n");
        
        account.setOverdraft(getOverdraft());
        
        return account;

    }

    public SavingAccount updateInterestRate(SavingAccount account) {
        scanner.nextLine();
        System.out.println(account);
        System.out.println("\n\n\n");
        
        account.setInterestRate(getInterestRate());
        
        return account;

    }

    public void updated(Account account) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Account updated succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(account);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notUpdated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Account couldn't be updated**********************************");
            System.out.println("\n\n");
            System.out.println("Error, check your inputs and try again.");
            Thread.sleep(4000);
        } catch (Exception e) { e.printStackTrace(); }  
    }

    public byte display() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Display account**********************************");
        System.out.println("\n\n\n");
        byte choice = -1;
        System.out.println("1 - All accounts");
        System.out.println("2 - by status");
        System.out.println("3 - by creation date");
        do{
            try{
                System.out.print("\nchoice: ");
                choice = scanner.nextByte();
            } catch( Exception e) { scanner.next(); }
        } while(choice < 1 || choice > 3 );
        return choice;

    }

    public void DisplayAccountsList(List<Account> accounts){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Display account**********************************");
        System.out.println("\n\n\n");
        if(! accounts.isEmpty() )
            for(Account account : accounts) 
                System.out.println(account);
        else 
            System.out.println("\n\n\n No founded Accounts");
        System.out.println("\n\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
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
                    System.out.println("Do u realy want to delete the account with that code ? [yes/no]");
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

    public AccountStatus getStatus() {
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

    public LocalDate getDate() {
        LocalDate date = null;
        boolean valid = false;
        do {
            try {
                int year = 0;
                byte month = 0;
                byte day = 0;

                System.out.println("date: ");
                do {
                    try {
                        System.out.print("Year: ");
                        year = scanner.nextInt();
                    } catch (Exception e) { scanner.next(); }
                } while( year > LocalDate.now().getYear() );
                do {
                    try {
                        System.out.print("Month: ");
                        month = scanner.nextByte();
                    } catch (Exception e) { scanner.next(); }
                } while( month > 12 || month < 1 );
                do {
                    try {
                        System.out.print("Day: ");
                        day = scanner.nextByte();
                    } catch (Exception e) { scanner.next(); }
                } while( day > 31 || (month % 2 == 0 && day > 30 ) || (month == 2 && day > 29 ) );
                date = LocalDate.of(year, month, day);
                valid = true;
            } catch ( Exception e) { scanner.next(); }
        } while( ! valid );

        return date;
    }
}
