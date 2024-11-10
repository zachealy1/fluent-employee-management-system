/**
 * The Main class serves as the entry point for the employee management system.
 * It demonstrates the creation and interaction of various employee types,
 * managers, and the use of different employee builder patterns.
 */
package com.employees.main;

import com.employees.builders.EmployeeBuilder;
import com.employees.builders.FluentEmployeeBuilder;
import com.employees.database.DatabaseAdministrator;
import com.employees.employees.Employee;
import com.employees.engineer.SoftwareEngineer;
import com.employees.engineer.SoftwareEngineerTitle;
import com.employees.manager.Manager;

/**
 * The Main class serves as the entry point for the employee management system.
 * It demonstrates the creation and interaction of various employee types,
 * managers, and the use of different employee builder patterns.
 */
public class Main {

    public static void main(String[] args) {
        // Create software engineers, a manager, and demonstrate their interactions
        SoftwareEngineer softwareEngineer1 = new SoftwareEngineer("Alice", 10, SoftwareEngineerTitle.JUNIOR_SWE);
        SoftwareEngineer softwareEngineer2 = new SoftwareEngineer("Bob", 10, SoftwareEngineerTitle.SWE);
        Manager engineeringManager = new Manager("Dave", 10);

        engineeringManager.add(softwareEngineer1);
        engineeringManager.add(softwareEngineer2);

        double engineeringManagerTotalPay = engineeringManager.calculateTotalPay();
        double softwareEngineer1TotalPay = softwareEngineer1.calculateTotalPay();
        double softwareEngineer2TotalPay = softwareEngineer2.calculateTotalPay();

        // Print total pay for engineering manager and software engineers
        System.out.println("engineeringManager total pay: £" + engineeringManagerTotalPay);
        System.out.println("softwareEngineer1 total pay: £" + softwareEngineer1TotalPay);
        System.out.println("softwareEngineer2 total pay: £" + softwareEngineer2TotalPay);
        System.out.println();

        // Create database administrators, a manager, and demonstrate their interactions
        DatabaseAdministrator databaseEngineer1 = new DatabaseAdministrator("Alan", 10, 5);
        DatabaseAdministrator databaseEngineer2 = new DatabaseAdministrator("Barry", 10, 10);
        Manager databaseManager = new Manager("Daniel", 10);

        databaseManager.add(databaseEngineer1);
        databaseManager.add(databaseEngineer2);

        double databaseManagerTotalPay = databaseManager.calculateTotalPay();
        double databaseEngineer1TotalPay = databaseEngineer1.calculateTotalPay();
        double databaseEngineer2TotalPay = databaseEngineer2.calculateTotalPay();

        // Print total pay for database manager and database engineers
        System.out.println("databaseManager total pay: £" + databaseManagerTotalPay);
        System.out.println("databaseEngineer1 total pay: £" + databaseEngineer1TotalPay);
        System.out.println("databaseEngineer2 total pay: £" + databaseEngineer2TotalPay);
        System.out.println();

        // Create a general manager and demonstrate interactions with different employees
        Manager manager = new Manager("James", 10);

        manager.add(databaseEngineer1);
        manager.add(softwareEngineer1);

        double managerTotalPay = manager.calculateTotalPay();

        // Print total pay for the general manager
        System.out.println("manager total pay: £" + managerTotalPay);
        System.out.println();

        // Create another manager and demonstrate interactions with previously created managers
        Manager managerTwo = new Manager("James", 10);

        managerTwo.add(manager);
        managerTwo.add(databaseManager);

        double managerTwoTotalPay = managerTwo.calculateTotalPay();

        // Print total pay for the second manager
        System.out.println("managerTwo total pay: £" + managerTwoTotalPay);
        System.out.println();

        // Demonstrate the use of the EmployeeBuilder to construct a complex employee hierarchy
        EmployeeBuilder builder = new EmployeeBuilder("Billy Gates", 100000.00);
        builder.addSoftwareEngineer("Timmy", 30000.00, SoftwareEngineerTitle.SWE);
        builder.startManager("Alice", 50000.00);
        builder.addDatabaseAdministrator("Tony", 20000.00, 0);
        builder.startManager("Rosie", 40000.00);
        builder.addDatabaseAdministrator("Ronald", 30000.00, 1);
        builder.endManager();
        builder.endManager();
        builder.addSoftwareEngineer("Sally", 30000.00, SoftwareEngineerTitle.SENIOR_SWE);
        Employee managerThree = builder.build();

        double managerThreeTotalPay = managerThree.calculateTotalPay();

        // Print total pay for the manager created using the EmployeeBuilder
        System.out.println("managerThree total pay: £" + managerThreeTotalPay);
        System.out.println();

        // Demonstrate the use of the FluentEmployeeBuilder to construct a complex employee hierarchy
        Employee fluentBuilderManager = new FluentEmployeeBuilder("Billy Gates", 100000.00)
                .addSoftwareEngineer("Jimmy", 30000.00, SoftwareEngineerTitle.SWE)
                .startManager("Alex", 50000.00)
                .addDatabaseAdministrator("Tony", 20000.00, 0)
                .startManager("Rosie", 40000.00)
                .addDatabaseAdministrator("Ronald", 30000.00, 1)
                .endManager()
                .endManager()
                .addSoftwareEngineer("Sally", 30000.00, SoftwareEngineerTitle.SENIOR_SWE)
                .build();

        double managerFourTotalPay = fluentBuilderManager.calculateTotalPay();

        // Print total pay for the manager created using the FluentEmployeeBuilder
        System.out.println("fluentBuilderManager total pay: £" + managerFourTotalPay);
    }
}
