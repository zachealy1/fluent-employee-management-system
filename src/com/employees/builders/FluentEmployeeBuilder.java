/**
 * The FluentEmployeeBuilder class provides a fluent interface for constructing complex
 * employee hierarchies. It allows for the creation and organization of managers,
 * software engineers, and database administrators in a more concise and readable manner.
 */
package com.employees.builders;

import com.employees.database.DatabaseAdministrator;
import com.employees.employees.Employee;
import com.employees.engineer.SoftwareEngineer;
import com.employees.engineer.SoftwareEngineerTitle;
import com.employees.manager.Manager;

import java.util.ArrayList;

/**
 * The FluentEmployeeBuilder class provides a fluent interface for constructing complex
 * employee hierarchies. It allows for the creation and organization of managers,
 * software engineers, and database administrators in a more concise and readable manner.
 */
public class FluentEmployeeBuilder {

    // ArrayList to keep track of the current manager being constructed
    private final ArrayList<Manager> currentManager = new ArrayList<>();

    /**
     * Constructs a FluentEmployeeBuilder with the initial manager.
     *
     * @param name The name of the initial manager.
     * @param pay  The pay of the initial manager.
     */
    public FluentEmployeeBuilder(String name, double pay) {
        currentManager.add(new Manager(name, pay));
    }

    /**
     * Starts a new manager under the current manager.
     *
     * @param name The name of the new manager.
     * @param pay  The pay of the new manager.
     * @return The FluentEmployeeBuilder instance for method chaining.
     */
    public FluentEmployeeBuilder startManager(String name, double pay) {
        Manager newManager = new Manager(name, pay);
        currentManager.get(currentManager.size() - 1).add(newManager);
        currentManager.add(newManager);
        return this;
    }

    /**
     * Ends the construction of the current manager.
     *
     * @return The FluentEmployeeBuilder instance for method chaining.
     */
    public FluentEmployeeBuilder endManager() {
        currentManager.remove(currentManager.get(currentManager.size() - 1));
        return this;
    }

    /**
     * Adds a software engineer under the current manager.
     *
     * @param name  The name of the software engineer.
     * @param pay   The pay of the software engineer.
     * @param title The title of the software engineer.
     * @return The FluentEmployeeBuilder instance for method chaining.
     */
    public FluentEmployeeBuilder addSoftwareEngineer(String name, double pay, SoftwareEngineerTitle title) {
        if (currentManager != null) {
            currentManager.get(currentManager.size() - 1).add(new SoftwareEngineer(name, pay, title));
        }
        return this;
    }

    /**
     * Adds a database administrator under the current manager.
     *
     * @param name            The name of the database administrator.
     * @param pay             The pay of the database administrator.
     * @param dbsResponsible The number of databases the administrator is responsible for.
     * @return The FluentEmployeeBuilder instance for method chaining.
     */
    public FluentEmployeeBuilder addDatabaseAdministrator(String name, double pay, int dbsResponsible) {
        if (currentManager != null) {
            currentManager.get(currentManager.size() - 1)
                    .add(new DatabaseAdministrator(name, pay, dbsResponsible));
        }
        return this;
    }

    /**
     * Builds and returns the initial manager created by the builder.
     *
     * @return The initial manager of the employee hierarchy.
     */
    public Employee build() {
        return currentManager.get(0);
    }
}



