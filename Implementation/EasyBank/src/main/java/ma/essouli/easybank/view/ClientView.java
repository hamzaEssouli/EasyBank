package ma.essouli.easybank.view;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

import ma.essouli.easybank.dto.Account;
import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Operation;

public class ClientView {
    private static ClientView instance = null;
    private final Scanner scanner = new Scanner(System.in);

    private ClientView(){}

    public static ClientView getInstance() {
        if( instance == null )
            instance = new ClientView();
        return instance;
    }

    public byte menu() {
        byte choice = -1;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Client menu**********************************");
            System.out.println("1 - Add");
            System.out.println("2 - Delete");
            System.out.println("3 - search by registration code");
            System.out.println("4 - display Clients list");
            System.out.println("5 - update an Client");
            System.out.println("6 - search by attribut");
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


    public Client create() {
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Add Client**********************************");
        System.out.println("(0): Back to main menu");
        System.out.println("\n\n");
        String lastName = getName("Last");
        String firstName = getName("first");
        LocalDate dateOfBirth = getDate("Birth");
        scanner.nextLine();
        String address = getAddress();
        String phoneNumber = getPhoneNumber();
        System.out.println("Employee");
        int employeeId = getId("create");
        return new Client(lastName, firstName, dateOfBirth, phoneNumber, address, employeeId);
    }
    public void created(Client client) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Client added succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(client);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    public void notCreated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Client couldn't be added**********************************");
            System.out.println("\n\n");
            System.out.println("check your inputs and try again");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }

    public int delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Delete Client**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("delete");
        return id;
    }
    public void deleted(int id) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Client deleted succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println("Client with registration number ( "+id+" ) deleted.");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    public void notDeleted() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Client couldn't be deleted**********************************");
            System.out.println("\n\n");
            System.out.println("Client may be not exist or have clients depend on it");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }


    public int searchByRegistrationCode() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Search Client by registration code**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("search");
        return id;
    }
    
    public byte founded(Client client) {
        byte choice = -1;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Client founded succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(client);
        System.out.println("\n\n");
        System.out.println("1 - show client accounts");
        System.out.println("2 - show client assistant");
        System.out.println("0 - back to menu");
        System.out.println('\n');
        do {
            try {
                System.out.print("Choice: ");
                choice = scanner.nextByte();
            } catch ( Exception e) { scanner.next(); }
        } while ( choice > 2 || choice < 0 );
        
        return choice;
    }

    public void notFounded() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Client not founded**********************************");
            System.out.println("\n\n");
            System.out.println("There is no Client with those credentials.");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }  
    }


    public void DisplayClientsList(List<Client> clients){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Display Clients**********************************");
        System.out.println("\n\n\n");
        if(! clients.isEmpty() )
            for(Client client : clients) 
                System.out.println(client);
        else 
            System.out.println("\n\n\n No founded Clients");
        System.out.println("\n\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public int edit() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Update Client**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("update");
        return id;
    }

    public Client update(Client client) {
        scanner.nextLine();
        System.out.println(client);
        System.out.println("\n\n\n");
        String lastName = getName("Last");
        String firstName = getName("First");
        LocalDate dateOfBirth = getDate("Birth");
        scanner.nextLine();
        String address = getAddress();
        String phoneNumber = getPhoneNumber();
        
        client.setLastName(lastName);
        client.setFirstName(firstName);
        client.setDateOfBirth(dateOfBirth);
        client.setPhoneNumber(phoneNumber);
        client.setAddress(address);
        return client;
    }

    public void updated(Client client) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Client updated succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(client);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notUpdated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Client couldn't be updated**********************************");
            System.out.println("\n\n");
            System.out.println("May the new provided information is taken by another Client, check your inputs and try again.");
            Thread.sleep(4000);
        } catch (Exception e) { e.printStackTrace(); }  
    }



    public String search() {
        String attribut = "";
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Search Clients by attribut**********************************");
        System.out.println("(0): Back to main menu");
        do {
            try {
                System.out.print("Attribut : ");
                attribut = scanner.nextLine();
            } catch ( Exception e) { scanner.next(); }
        } while( attribut.length() < 1 || attribut.length() > 50 );
        return attribut;
    }






    public void showClientAssistant(List<Client> clients) {
        System.out.println("[\n\n");
        if( ! clients.isEmpty() )
            for (Client client : clients) {
                System.out.println(client);
            }
        else System.out.println("This Client have no clients"); 
        System.out.println("\n\n]");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void showClientAccounts(List<Account> accounts) {
        System.out.println("[\n\n");
        if( ! accounts.isEmpty() )
            for (Account account : accounts) {
                System.out.println(account);
            }
        else System.out.println("This Client haven't done any operations"); 
        System.out.println("\n\n]");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }








    private String getName(String label) {
        String name = "";
        do {
            try {
                System.out.print(label+" name: ");
                name = scanner.nextLine();
            } catch ( Exception e) { scanner.next(); }
        } while( name.length() < 1 || name.length() > 30 );
        return name;
    }

    private LocalDate getDate(String label) {
        LocalDate date = null;
        boolean valid = false;
        do {
            try {
                int year = 0;
                byte month = 0;
                byte day = 0;

                System.out.println(label +" date: ");
                do {
                    try {
                        System.out.print("Year: ");
                        year = scanner.nextInt();
                    } catch (Exception e) { scanner.next(); }
                } while( year > LocalDate.now().getYear() || year < LocalDate.now().getYear() - 120 );
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
                if(label == "Birth") {
                    int age = Period.between(date, LocalDate.now()).getYears();
                    if( age > 18 ) 
                        valid = true;
                } else valid = true;

            } catch ( Exception e) { scanner.next(); }
        } while( ! valid );

        return date;
    }

    private String getAddress() {
        String address = "";
        
        do {
            try {
                System.out.print("address : ");
                address = scanner.nextLine();
            } catch ( Exception e) { scanner.next(); }
        } while( address.length() < 11 || address.length() > 50 );
        return address;
    }

    private String getPhoneNumber() {
        String phoneNumber = "";
        boolean valid = false;
        do {
            try {
                System.out.print("Phone number(only degits): +");
                phoneNumber = scanner.nextLine();
                if (phoneNumber.compareTo("0") == 0 ) return null;
                new BigInteger(phoneNumber);
                valid = true;
            }catch(Exception e){ valid = false; }
        } while(phoneNumber.length() > 15 || phoneNumber.length() < 12 || ! valid );
        return phoneNumber;
    }

    private int getId(String lable) {
        int id = -1;
        boolean valid = false;
        String answer = "";
        do {
            try {
                System.out.print("Registration code: ");
                id = scanner.nextInt();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid );
        if( lable.equals("delete") ) {
            scanner.nextLine();
            do {
                try {
                    System.out.println("Are u realy want to delete the Client with that registration code ? [yes/no]");
                    answer = scanner.nextLine().toLowerCase();
                } catch (Exception e) { scanner.next(); }
            } while(  ! answer.equals("yes")  &&  ! answer.equals("no") || answer.equals("")  );
            if( answer.compareTo("no") == 0 ) 
                id = 0;
        }

        return id;
    }
}
