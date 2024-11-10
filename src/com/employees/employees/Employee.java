/**
 * The Employee class represents an abstract employee in an employee management system.
 * It provides a base class for specific types of employees and includes methods
 * to calculate total pay, get and set the employee's name, and get and set the employee's pay.
 */
package com.employees.employees;

/**
 * The Employee class represents an abstract employee in an employee management system.
 * It provides a base class for specific types of employees and includes methods
 * to calculate total pay, get and set the employee's name, and get and set the employee's pay.
 */
public abstract class Employee {

    // Fields to store the name and pay of the employee
    private String name;
    private double pay;

    /**
     * Constructs an Employee object with the specified name and pay.
     *
     * @param name The name of the employee.
     * @param pay  The pay of the employee.
     */
    public Employee(String name, double pay) {
        this.name = name;
        this.pay = pay;
    }

    /**
     * Abstract method to calculate the total pay of the employee.
     *
     * @return The total pay of the employee.
     */
    public abstract double calculateTotalPay();

    /**
     * Gets the name of the employee.
     *
     * @return The name of the employee.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the employee.
     *
     * @param name The new name for the employee.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the pay of the employee.
     *
     * @return The pay of the employee.
     */
    public double getPay() {
        return pay;
    }

    /**
     * Sets the pay of the employee.
     *
     * @param pay The new pay for the employee.
     */
    public void setPay(double pay) {
        this.pay = pay;
    }
}

