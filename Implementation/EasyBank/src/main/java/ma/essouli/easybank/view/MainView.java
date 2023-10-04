package ma.essouli.easybank.view;

import java.util.Scanner;

public class MainView {
    
    private static MainView instance = null;
    private Scanner scanner = new Scanner(System.in);
    
    private MainView(){}
    public static MainView getInstance() {
        if( instance == null )
            instance = new MainView();
        return instance;
    }

    public byte display() {
        byte choice = 0;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("***************************Bank managment************************");
            System.out.println("1 - Employee management");
            System.out.println("2 - Client management");
            System.out.println("3 - Account management");
            System.out.println("4 - Operation management");
            System.out.println("5 - Mission management");
            System.out.println("6 - Mission assignment management");
            System.out.println("7 - Agency management");
            System.out.println("8 - Credit request management");
            System.out.println("0 - Exit");
            System.out.println("\n");
            System.out.print("Enter your choice: ");
            try {
                choice = scanner.nextByte();
            }catch(Exception e ) {
                scanner.next();
            }
        } while( choice < 0  || choice > 6 );
        
        return choice;
    }

    public void goodBye() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Good bye...!");
        try {
            Thread.sleep(3000);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
