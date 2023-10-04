package ma.essouli.easybank.controller;

import ma.essouli.easybank.view.MainView;

public class MainController {
    
    private static final MainView view = MainView.getInstance();

    private static final EmployeeController employee = EmployeeController.getInstance();
    private static final ClientController client = ClientController.getInstance();
    private static final AccountController account = AccountController.getInstance();
    private static final SimpleOperationController operation = SimpleOperationController.getInstance();
    private static final MissionController mission = MissionController.getInstance();
    private static final MissionAssignmentController missionAssignments = MissionAssignmentController.getInstance();

    public static void main() {
        byte choice = view.display();
        switch(choice) {
            case 0:
                view.goodBye();
                System.exit(0);
            case 1: 
                employee.main();
                break;
            case 2: 
                client.main();
                break;
            case 3:
                account.main();
                break;
            case 4:
                operation.main();
                break;
            case 5:
                mission.main();
                break;
            case 6:
                missionAssignments.main();
                break;
        }
    }

}
