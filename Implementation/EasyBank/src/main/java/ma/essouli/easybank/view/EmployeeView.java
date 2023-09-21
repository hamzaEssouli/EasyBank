package ma.essouli.easybank.view;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import ma.essouli.easybank.dto.Employee;

public class EmployeeView {
    
    private static EmployeeView instance = null;
    private final Scanner scanner = new Scanner(System.in);

    private EmployeeView(){}

    public static EmployeeView getInstance() {
        if( instance == null )
            instance = new EmployeeView();
        return instance;
    }

    public byte menu() {
        byte choice = -1;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Employee menu**********************************");
            System.out.println("1 - Add");
            System.out.println("0 - back to main menu");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextByte();
            } catch (Exception e) {
                scanner.next();
            }
        } while( choice < 0 || choice > 1);

        return choice;
    }


    public Employee create() {
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Add Employee**********************************");
        System.out.println("(0): Back to main menu");
        System.out.println("\n\n");
        String lastName = getName("Last");
        String firstName = getName("first");
        LocalDate dateOfBirth = getDate("Birth");
        LocalDate recruitmentDate = getDate("Recruitment");
        scanner.nextLine();
        String email = getEmail();
        String phoneNumber = getPhoneNumber();
        return new Employee(lastName, firstName, dateOfBirth, phoneNumber, recruitmentDate, email);
    }
    public void created(Employee employee) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Employee added succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(employee);
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

    private String getEmail() {
        String email = "";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        do {
            try {
                System.out.print("Email : ");
                email = scanner.nextLine();
            } catch ( Exception e) { scanner.next(); }
        } while( email.length() < 1 || email.length() > 50 || ! email.matches(emailRegex) );
        return email;
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


}


