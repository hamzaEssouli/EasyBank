package ma.essouli.easybank.view;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import ma.essouli.easybank.dto.Employee;
import ma.essouli.easybank.dto.Mission;
import ma.essouli.easybank.dto.MissionAssignment;

public class MissionAssignementView {
    
    private static MissionAssignementView instance = null;
    
    private Scanner scanner = null;

    private MissionAssignementView() {
        this.scanner = new Scanner( System.in );
    }

    public static MissionAssignementView getInstance() {
        if( instance == null )
            instance = new MissionAssignementView();
        return instance;
    }

    public byte menu() {
        byte choice = -1;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Mission assignments menu**********************************");
            System.out.println("1 - Assign");
            System.out.println("2 - Delete assignemnt");
            System.out.println("3 - display");
            System.out.println("4 - statistics");
            System.out.println("0 - back to main menu");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextByte();
            } catch (Exception e) {
                scanner.next();
            }
        } while( choice < 0 || choice > 4);

        return choice;
    }

    public MissionAssignment create() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Assign mission**********************************");
        scanner.nextLine();
        System.out.print("Employee");
        int employeeId = getId("");
        System.out.print("Mission");
        int missionId = getId("");
        LocalDate startDate = getDate("assignment start");
        MissionAssignment assignment = new MissionAssignment();
        Employee employee = new Employee();
        Mission mission = new Mission();
        employee.setId(employeeId);
        mission.setId(missionId);
        assignment.setAssignmentStartDate(startDate);
        assignment.setEmployee(employee);
        assignment.setMission(mission);

        return assignment;
    }

    public void created(MissionAssignment assignment) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************assignment added succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(assignment);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    public void notCreated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************assignment couldn't be added**********************************");
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
                System.out.print(" code: ");
                id = scanner.nextInt();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid );
        if( lable.equals("delete") ) {
            scanner.nextLine();
            do {
                try {
                    System.out.println("Do u realy want to delete the assignment with that code ? [yes/no]");
                    answer = scanner.nextLine().toLowerCase();
                } catch (Exception e) { scanner.next(); }
            } while(  ! answer.equals("yes")  &&  ! answer.equals("no") || answer.equals("")  );
            if( answer.compareTo("no") == 0 ) 
                id = 0;
        }

        return id;
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
}
