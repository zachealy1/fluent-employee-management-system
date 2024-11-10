/**
 * The SoftwareEngineer class represents a specific type of employee, namely a software engineer,
 * in an employee management system. It extends the Employee class and includes methods to calculate total pay,
 * determine the bonus based on the engineer's title, and get the pay multiplier based on the title.
 */
package com.employees.engineer;

import com.employees.employees.Employee;

/**
 * The SoftwareEngineer class represents a specific type of employee, namely a software engineer,
 * in an employee management system. It extends the Employee class and includes methods to calculate total pay,
 * determine the bonus based on the engineer's title, and get the pay multiplier based on the title.
 */
public class SoftwareEngineer extends Employee {

    // Constants representing bonuses and multipliers for different software engineer titles
    /** Represents the junior software engineer bonus. */
    public static final int JUNIOR_SWE_BONUS = 3000;
    /** Represents the standard software engineer bonus. */
    public static final int SWE_BONUS = 10000;
    /** Represents the senior software engineer bonus. */
    public static final int SENIOR_SWE_BONUS = 25000;
    /** Represents the junior software engineer multiplier. */
    public static final double JUNIOR_SWE_MULTIPLIER = 1;
    /** Represents the standard software engineer multiplier. */
    public static final double SWE_MULTIPLIER = 1.5;
    /** Represents the senior software engineer multiplier. */
    public static final double SENIOR_SWE_MULTIPLIER = 2;

    // Field to store the title of the software engineer
    private SoftwareEngineerTitle title;

    /**
     * Constructs a SoftwareEngineer object with the specified name, pay, and title.
     *
     * @param name  The name of the software engineer.
     * @param pay   The pay of the software engineer.
     * @param title The title of the software engineer.
     */
    public SoftwareEngineer(String name, double pay, SoftwareEngineerTitle title) {
        super(name, pay);
        this.title = title;
    }

    /**
     * Calculates the total pay of the software engineer, including the bonus and pay multiplier.
     *
     * @return The total pay of the software engineer.
     */
    @Override
    public double calculateTotalPay() {
        return this.getBonus() + (this.getPay() * this.getMultiplier());
    }

    /**
     * Gets the bonus based on the software engineer's title.
     *
     * @return The bonus amount.
     */
    public double getBonus() {
        if (title.equals(SoftwareEngineerTitle.JUNIOR_SWE)) {
            return JUNIOR_SWE_BONUS;
        } else if (title.equals(SoftwareEngineerTitle.SWE)) {
            return SWE_BONUS;
        } else {
            return SENIOR_SWE_BONUS;
        }
    }

    /**
     * Gets the pay multiplier based on the software engineer's title.
     *
     * @return The pay multiplier.
     */
    public double getMultiplier() {
        if (title.equals(SoftwareEngineerTitle.JUNIOR_SWE)) {
            return JUNIOR_SWE_MULTIPLIER;
        } else if (title.equals(SoftwareEngineerTitle.SWE)) {
            return SWE_MULTIPLIER;
        } else {
            return SENIOR_SWE_MULTIPLIER;
        }
    }

    /**
     * Gets the title of the software engineer.
     *
     * @return The title.
     */
    public SoftwareEngineerTitle getTitle() {
        return title;
    }

    /**
     * Sets the title of the software engineer.
     *
     * @param title The new title.
     */
    public void setTitle(SoftwareEngineerTitle title) {
        this.title = title;
    }
}

