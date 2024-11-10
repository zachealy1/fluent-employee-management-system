/**
 * The Manager class represents a manager in an employee management system.
 * It extends the Employee class and includes methods to manage subordinates,
 * calculate total pay, and print all subordinates recursively.
 */
package com.employees.manager;

import com.employees.employees.Employee;

import java.util.ArrayList;

/**
 * The Manager class represents a manager in an employee management system.
 * It extends the Employee class and includes methods to manage subordinates,
 * calculate total pay, and print all subordinates recursively.
 */
public class Manager extends Employee {

    // ArrayList to store the subordinates of the manager
    private ArrayList<Employee> subordinates = new ArrayList<>();

    /**
     * Constructs a Manager object with the specified name and pay.
     *
     * @param name The name of the manager.
     * @param pay  The pay of the manager.
     */
    public Manager(String name, double pay) {
        super(name, pay);
    }

    /**
     * Adds a subordinate to the manager's list of subordinates.
     *
     * @param subordinate The employee to be added as a subordinate.
     */
    public void add(Employee subordinate) {
        subordinates.add(subordinate);
    }

    /**
     * Removes a subordinate from the manager's list of subordinates.
     *
     * @param subordinate The employee to be removed as a subordinate.
     */
    public void remove(Employee subordinate) {
        subordinates.remove(subordinate);
    }

    /**
     * Gets the list of subordinates for the manager.
     *
     * @return The list of subordinates.
     */
    public ArrayList<Employee> getSubordinates() {
        return subordinates;
    }

    /**
     * Sets the list of subordinates for the manager.
     *
     * @param subordinates The new list of subordinates.
     */
    public void setSubordinates(ArrayList<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    /**
     * Calculates the total pay of the manager and all subordinates recursively.
     *
     * @return The total pay of the manager and subordinates.
     */
    @Override
    public double calculateTotalPay() {
        double totalPay = this.getPay();
        for (Employee subordinate : this.getSubordinates()) {
            totalPay += subordinate.calculateTotalPay();
        }
        return totalPay;
    }

    /**
     * Prints the names of all subordinates of the manager recursively.
     *
     * @param manager The manager whose subordinates will be printed.
     */
    public static void printAllSubordinates(Manager manager) {
        System.out.println("All Subordinates of Manager " + manager.getName() + ":");
        printAllSubordinatesRecursive(manager, 1);
    }

    /**
     * Helper method to print subordinates recursively.
     *
     * @param employee The current employee being processed.
     * @param level    The depth of recursion, used for indentation.
     */
    private static void printAllSubordinatesRecursive(Employee employee, int level) {
        if (employee instanceof Manager manager) {
            for (Employee subordinate : manager.getSubordinates()) {
                System.out.println("  ".repeat(level) + subordinate.getName());
                printAllSubordinatesRecursive(subordinate, level + 1);
            }
        }
    }
}

