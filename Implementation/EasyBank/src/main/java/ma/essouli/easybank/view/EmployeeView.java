package ma.essouli.easybank.view;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Scanner;

import ma.essouli.easybank.dto.Client;
import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.dto.MissionAssignment;
import ma.essouli.easybank.dto.Operation;

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
            System.out.println("2 - Delete");
            System.out.println("3 - search by registration code");
            System.out.println("4 - display employees list");
            System.out.println("5 - update an employee");
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
    public void notCreated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Employee couldn't be added**********************************");
            System.out.println("\n\n");
            System.out.println("check your inputs and try again");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }

    public int delete() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Delete employee**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("delete");
        return id;
    }
    public void deleted(int id) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Employee deleted succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println("Employee with registration number ( "+id+" ) deleted.");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    public void notDeleted() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Employee couldn't be deleted**********************************");
            System.out.println("\n\n");
            System.out.println("Employee may be not exist or have clients depend on it");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }        
    }


    public int searchByRegistrationCode() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Search employee by registration code**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("search");
        return id;
    }
    
    public byte founded(Employee employee) {
        byte choice = -1;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Employee founded succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(employee);
        System.out.println("\n\n");
        System.out.println("1 - show employee clients");
        System.out.println("2 - show employee mission assignments");
        System.out.println("3 - show employee oerations");
        System.out.println("0 - back to menu");
        System.out.println('\n');
        do {
            try {
                System.out.print("Choice: ");
                choice = scanner.nextByte();
            } catch ( Exception e) { scanner.next(); }
        } while ( choice > 3 || choice < 0 );
        
        return choice;
    }

    public void notFounded() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Employee not founded**********************************");
            System.out.println("\n\n");
            System.out.println("There is no employee with those credentials.");
            Thread.sleep(3000);
        } catch (Exception e) { e.printStackTrace(); }  
    }


    public void DisplayEmployeesList(List<Employee> employees){
        scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Display Employees**********************************");
        System.out.println("\n\n\n");
        for(Employee employee : employees) 
            System.out.println(employee);
        System.out.println("\n\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public int edit() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Update employee**********************************");
        System.out.println("(0): Back to main menu");
        int id = getId("update");
        return id;
    }

    public Employee update(Employee employee) {
        scanner.nextLine();
        System.out.println(employee);
        System.out.println("\n\n\n");
        String lastName = getName("Last");
        String firstName = getName("First");
        LocalDate dateOfBirth = getDate("Birth");
        LocalDate recruitmentDate = getDate("Recruitment");
        scanner.nextLine();
        String email = getEmail();
        String phoneNumber = getPhoneNumber();
        
        employee.setLastName(lastName);
        employee.setFirstName(firstName);
        employee.setDateOfBirth(dateOfBirth);
        employee.setRecruitmentDate(recruitmentDate);
        employee.setPhoneNumber(phoneNumber);
        employee.setEmail(email);
        return employee;
    }

    public void updated(Employee employee) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Employee updated succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(employee);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }

    public void notUpdated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Employee couldn't be updated**********************************");
            System.out.println("\n\n");
            System.out.println("May the new provided information is taken by another employee, check your inputs and try again.");
            Thread.sleep(4000);
        } catch (Exception e) { e.printStackTrace(); }  
    }










    public void showEmployeeClients(List<Client> clients) {
        System.out.println("[\n\n");
        if( ! clients.isEmpty() )
            for (Client client : clients) {
                System.out.println(client);
            }
        else System.out.println("This Employee have no clients"); 
        System.out.println("\n\n]");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    public void showEmployeeMissionAssignments(List<MissionAssignment> assignments) {
        System.out.println("[\n\n");
        if( ! assignments.isEmpty() )
            for (MissionAssignment assignment : assignments) 
                System.out.println(assignment);
            
        else System.out.println("This Employee have no mission assignments"); 
        System.out.println("\n\n]");
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    
    public void showEmployeeOperations(List<Operation> operations) {
        System.out.println("[\n\n");
        if( ! operations.isEmpty() )
            for (Operation operation : operations) {
                System.out.println(operation);
            }
        else System.out.println("This Employee haven't done any operations"); 
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
                    System.out.println("Are u realy want to delete the employee with that registration code ? [yes/no]");
                    answer = scanner.nextLine().toLowerCase();
                } catch (Exception e) { scanner.next(); }
            } while(  ! answer.equals("yes")  &&  ! answer.equals("no") || answer.equals("")  );
            if( answer.compareTo("no") == 0 ) 
                id = 0;
        }

        return id;
    }

}


