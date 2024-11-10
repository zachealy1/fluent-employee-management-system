/**
 * The EmployeeBuilder class facilitates the construction of complex employee hierarchies.
 * It provides methods to create and organize managers, software engineers, and database administrators.
 */
package com.employees.builders;

import com.employees.database.DatabaseAdministrator;
import com.employees.engineer.SoftwareEngineer;
import com.employees.engineer.SoftwareEngineerTitle;
import com.employees.manager.Manager;

import java.util.ArrayList;

/**
 * The EmployeeBuilder class facilitates the construction of complex employee hierarchies.
 * It provides methods to create and organize managers, software engineers, and database administrators.
 */
public class EmployeeBuilder {

    // ArrayList to keep track of the current manager being constructed
    private final ArrayList<Manager> currentManager = new ArrayList<>();

    /**
     * Constructs an EmployeeBuilder with the initial manager.
     *
     * @param name The name of the initial manager.
     * @param pay  The pay of the initial manager.
     */
    public EmployeeBuilder(String name, double pay) {
        currentManager.add(new Manager(name, pay));
    }

    /**
     * Starts a new manager under the current manager.
     *
     * @param name The name of the new manager.
     * @param pay  The pay of the new manager.
     */
    public void startManager(String name, double pay) {
        Manager newManager = new Manager(name, pay);
        currentManager.get(currentManager.size() - 1).add(newManager);
        currentManager.add(newManager);
    }

    /**
     * Ends the construction of the current manager.
     */
    public void endManager() {
        currentManager.remove(currentManager.get(currentManager.size() - 1));
    }

    /**
     * Adds a software engineer under the current manager.
     *
     * @param name  The name of the software engineer.
     * @param pay   The pay of the software engineer.
     * @param title The title of the software engineer.
     */
    public void addSoftwareEngineer(String name, double pay, SoftwareEngineerTitle title) {
        if (currentManager != null) {
            currentManager.get(currentManager.size() - 1).add(new SoftwareEngineer(name, pay, title));
        }
    }

    /**
     * Adds a database administrator under the current manager.
     *
     * @param name            The name of the database administrator.
     * @param pay             The pay of the database administrator.
     * @param dbsResponsible The number of databases the administrator is responsible for.
     */
    public void addDatabaseAdministrator(String name, double pay, int dbsResponsible) {
        if (currentManager != null) {
            currentManager.get(currentManager.size() - 1)
                    .add(new DatabaseAdministrator(name, pay, dbsResponsible));
        }
    }

    /**
     * Builds and returns the initial manager created by the builder.
     *
     * @return The initial manager of the employee hierarchy.
     */
    public Manager build() {
        return currentManager.get(0);
    }
}



