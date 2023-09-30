package ma.essouli.easybank.view;

import java.util.Scanner;

import ma.essouli.easybank.dto.Mission;

public class MissionView {
    
    private static MissionView instance = null;

    private Scanner scanner = null;

    private MissionView() {
        this.scanner = new Scanner( System.in );
    }

    public static MissionView getInstance() {
        if( instance == null )
            instance = new MissionView();
        return instance;
    }

    public byte menu() {
        byte choice = -1;
        do{
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Mission menu**********************************");
            System.out.println("1 - Add");
            System.out.println("2 - Delete");
            System.out.println("0 - back to main menu");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextByte();
            } catch (Exception e) {
                scanner.next();
            }
        } while( choice < 0 || choice > 3);

        return choice;
    }

    public Mission create() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Add mission**********************************");
        scanner.nextLine();
        String name = getName();
        String description = getDescription();

        Mission mission = new Mission();
        mission.setName(name);
        mission.setDescription(description);

        return mission;

    }

    public void created(Mission mission) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("*******************************Mission added succsessfully**********************************");
        System.out.println("\n\n");
        System.out.println(mission);
        System.out.println("\n\n");
        System.out.println("Enter some input to back to main menu.");
        scanner.next();
    }
    public void notCreated() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("*******************************Mission couldn't be added**********************************");
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
                System.out.print("code: ");
                id = scanner.nextInt();
                valid = true;
            } catch( Exception e) { scanner.next(); }
        } while( ! valid );
        if( lable.equals("delete") ) {
            scanner.nextLine();
            do {
                try {
                    System.out.println("Do u realy want to delete the mission with that  code ? [yes/no]");
                    answer = scanner.nextLine().toLowerCase();
                } catch (Exception e) { scanner.next(); }
            } while(  ! answer.equals("yes")  &&  ! answer.equals("no") || answer.equals("")  );
            if( answer.compareTo("no") == 0 ) 
                id = 0;
        }

        return id;
    }

    private String getName() {
        String name = "";
        do {
            try {
                System.out.print("Mission name: ");
                name = scanner.nextLine();
            } catch ( Exception e) { scanner.next(); }
        } while( name.length() < 1 || name.length() > 30 );
        return name;
    }
    
    private String getDescription() {
        String description = "";
        do {
            try {
                System.out.print("Description: ");
                description = scanner.nextLine();
            } catch( Exception e ) { scanner.next(); }
        } while( description.length() < 1 || description.length() > 255 );

        return description;
    }

}
