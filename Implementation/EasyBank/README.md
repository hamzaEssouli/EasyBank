Easy Bank
===
A bank management console application build with JAVA and postgreSQL.
## Papar Information
- Author:  `Essouli Hamza`

## Install & Dependence
- JDK 20
- PostgreSQL Java Driver 

## Dataset Preparation
| Dataset | Download |
| ---     | ---   |
| dataset-A | [download]() |


## Directory Hierarchy
```
|—— .gitignore
|—— README.md
|—— bin
|    |—— ma
|        |—— essouli
|            |—— easybank
|                |—— App.class
|                |—— controller
|                    |—— AccountController.class
|                    |—— ClientController.class
|                    |—— CurrentAccountController.class
|                    |—— EmployeeController.class
|                    |—— MainController.class
|                    |—— MissionAssignmentController.class
|                    |—— MissionController.class
|                    |—— OperationController.class
|                    |—— SavingAccountController.class
|                |—— dao
|                    |—— AccountDAO.class
|                    |—— ClientDAO.class
|                    |—— CurrentAccountDAO.class
|                    |—— Dao.class
|                    |—— EmployeeDAO.class
|                    |—— MissionAssignmentDAO.class
|                    |—— MissionDAO.class
|                    |—— OperationDAO.class
|                    |—— SavingAccountDAO.class
|                |—— daoImp
|                    |—— AccountDAOImp.class
|                    |—— ClientDAOImp.class
|                    |—— CurrentAccountDAOImp.class
|                    |—— EmployeeDAOImp.class
|                    |—— MissionAssignementDAOImp.class
|                    |—— MissionDAOImp.class
|                    |—— OperationDAOImp.class
|                    |—— SavingAccountDAOImp.class
|                |—— dto
|                    |—— Account.class
|                    |—— Client.class
|                    |—— CurrentAccount.class
|                    |—— Employee.class
|                    |—— Mission.class
|                    |—— MissionAssignment.class
|                    |—— Operation.class
|                    |—— Person.class
|                    |—— SavingAccount.class
|                |—— enums
|                    |—— AccountStatus.class
|                    |—— OperationType.class
|                |—— services
|                    |—— AccountService.class
|                    |—— ClientService.class
|                    |—— CurrentAccountService.class
|                    |—— EmployeeService.class
|                    |—— MissionAssignementService.class
|                    |—— MissionService.class
|                    |—— OperationService.class
|                    |—— SavingAccountService.class
|                |—— utilities
|                    |—— DataBaseAccessLayer.class
|                |—— view
|                    |—— AccountView.class
|                    |—— ClientView.class
|                    |—— CurrentAccountView.class
|                    |—— EmployeeView.class
|                    |—— MainView.class
|                    |—— MissionAssignementView.class
|                    |—— MissionView.class
|                    |—— OperationView.class
|                    |—— SavingAccountView.class
|—— lib
|    |—— postgresql-42.6.0.jar
|—— src
|    |—— main
|        |—— java
|            |—— ma
|                |—— essouli
|                    |—— easybank
|                        |—— App.java
|                        |—— controller
|                            |—— AccountController.java
|                            |—— ClientController.java
|                            |—— CurrentAccountController.java
|                            |—— EmployeeController.java
|                            |—— MainController.java
|                            |—— MissionAssignmentController.java
|                            |—— MissionController.java
|                            |—— OperationController.java
|                            |—— SavingAccountController.java
|                        |—— dao
|                            |—— AccountDAO.java
|                            |—— ClientDAO.java
|                            |—— CurrentAccountDAO.java
|                            |—— Dao.java
|                            |—— EmployeeDAO.java
|                            |—— MissionAssignmentDAO.java
|                            |—— MissionDAO.java
|                            |—— OperationDAO.java
|                            |—— SavingAccountDAO.java
|                        |—— daoImp
|                            |—— AccountDAOImp.java
|                            |—— ClientDAOImp.java
|                            |—— CurrentAccountDAOImp.java
|                            |—— EmployeeDAOImp.java
|                            |—— MissionAssignementDAOImp.java
|                            |—— MissionDAOImp.java
|                            |—— OperationDAOImp.java
|                            |—— SavingAccountDAOImp.java
|                        |—— dto
|                            |—— Account.java
|                            |—— Client.java
|                            |—— CurrentAccount.java
|                            |—— Employee.java
|                            |—— Mission.java
|                            |—— MissionAssignment.java
|                            |—— Operation.java
|                            |—— Person.java
|                            |—— SavingAccount.java
|                        |—— enums
|                            |—— AccountStatus.java
|                            |—— OperationType.java
|                        |—— services
|                            |—— AccountService.java
|                            |—— ClientService.java
|                            |—— CurrentAccountService.java
|                            |—— EmployeeService.java
|                            |—— MissionAssignementService.java
|                            |—— MissionService.java
|                            |—— OperationService.java
|                            |—— SavingAccountService.java
|                        |—— utilities
|                            |—— DataBaseAccessLayer.java
|                        |—— view
|                            |—— AccountView.java
|                            |—— ClientView.java
|                            |—— CurrentAccountView.java
|                            |—— EmployeeView.java
|                            |—— MainView.java
|                            |—— MissionAssignementView.java
|                            |—— MissionView.java
|                            |—— OperationView.java
|                            |—— SavingAccountView.java
|    |—— resources
|        |—— SQLScripts
|            |—— Tables
|                |—— Accounts.sql
|                |—— Clients.sql
|                |—— CurrentAccount.sql
|                |—— Employees.sql
|                |—— MissionAssignements.sql
|                |—— Missions.sql
|                |—— Operations.sql
|                |—— SavingAccounts.sql
|            |—— Types
|                |—— AccountStatus.sql
|                |—— OperationType.sql
|    |—— test
|        |—— java
|            |—— DAOImpl
```
## Code Details
### Tested Platform
- software
  ```
  OS: Debian unstable (May 2021), Ubuntu LTS
  JDK: 20
  ```
- hardware
  ```
  CPU: Intel CORE I5 12th
  GPU: Nvidia RTX3090 (24GB)
  ```


