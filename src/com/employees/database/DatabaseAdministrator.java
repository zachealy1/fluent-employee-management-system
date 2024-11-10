/**
 * The DatabaseAdministrator class represents a specific type of employee, namely a database administrator,
 * in an employee management system. It extends the Employee class and includes methods to calculate total pay,
 * get the number of databases the administrator is responsible for, and increment the count of databases.
 */
package com.employees.database;

import com.employees.employees.Employee;

/**
 * The DatabaseAdministrator class represents a specific type of employee, namely a database administrator,
 * in an employee management system. It extends the Employee class and includes methods to calculate total pay,
 * get the number of databases the administrator is responsible for, and increment the count of databases.
 */
public class DatabaseAdministrator extends Employee {

    /** Constant representing the pay per database for a database administrator */
    public static final int PAY_PER_DATABASE = 800;

    // Field to store the number of databases the administrator is responsible for
    private int dbsResponsible;

    /**
     * Constructs a DatabaseAdministrator object with the specified name, pay, and number of databases.
     *
     * @param name           The name of the database administrator.
     * @param pay            The pay of the database administrator.
     * @param dbsResponsible The number of databases the administrator is responsible for.
     */
    public DatabaseAdministrator(String name, double pay, int dbsResponsible) {
        super(name, pay);
        this.dbsResponsible = dbsResponsible;
    }

    /**
     * Calculates the total pay of the database administrator, including the pay per database.
     *
     * @return The total pay of the database administrator.
     */
    @Override
    public double calculateTotalPay() {
        return this.getPay() + (PAY_PER_DATABASE * dbsResponsible);
    }

    /**
     * Gets the number of databases the administrator is responsible for.
     *
     * @return The number of databases.
     */
    public int getDbsResponsible() {
        return dbsResponsible;
    }

    /**
     * Increments the count of databases the administrator is responsible for.
     */
    public void incrementDbsResponsible() {
        dbsResponsible++;
    }
}

