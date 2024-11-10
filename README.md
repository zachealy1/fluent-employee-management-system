# Employee Management System

This project is an Employee Management System developed in Java. It provides a structured way to create and manage different employee types, including `SoftwareEngineer`, `DatabaseAdministrator`, and `Manager`. The project uses the Builder and Fluent Builder patterns to facilitate flexible and readable employee object creation.

**This work was completed as a part of my undergraduate degree in Applied Software Engineering at Swansea, which CGI Inc. sponsored.**

## Project Structure

The project is organised as follows:

- **Employee.java**: A base class representing a general employee, containing attributes like name, ID, and department.
- **SoftwareEngineer.java**: Extends `Employee` and represents a software engineer with specific attributes and methods.
- **DatabaseAdministrator.java**: Extends `Employee` and represents a database administrator.
- **Manager.java**: Extends `Employee` and represents a manager with potentially unique attributes and responsibilities.
- **EmployeeBuilder.java**: Implements the Builder pattern for constructing `Employee` objects.
- **FluentEmployeeBuilder.java**: An advanced builder that uses the Fluent Builder pattern for more intuitive and readable employee creation.
- **SoftwareEngineerTitle.java**: Likely an enumeration or class-defining title for software engineers.
- **Main.java**: The main entry point for running the application and demonstrating various employee creation methods.

## Features

- **Employee Management**: Supports creating and managing various types of employees, each with its attributes and behaviours.
- **Builder Pattern**: Provides the `EmployeeBuilder` class to simplify and streamline creating employee objects.
- **Fluent Interface**: Uses `FluentEmployeeBuilder` for a more readable and flexible employee-building process.
- **Employee Specializations**: Includes specialised employee types such as software engineers, database administrators, and managers, each with unique characteristics.

## Getting Started

### Prerequisites

- Java 8 or later
- An IDE like IntelliJ IDEA or Eclipse for running the project

### Setup

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Compile and run the project.

### Running the Application

1. Run the `Main` class to start the application.
2. The program will demonstrate the creation of different employee types using both the standard builder and the fluent builder patterns.

## Usage

- **Creating Employees**: Use `EmployeeBuilder` or `FluentEmployeeBuilder` to create various types of employees, allowing for flexible and readable construction of complex objects.
- **Employee Specializations**: Create specific types of employees, such as software engineers, managers, or database administrators, each with tailored attributes and methods.

## Example Code

Here's a sample code snippet demonstrating how to use the Fluent Builder pattern to create an employee:

```java
Employee softwareEngineer = new FluentEmployeeBuilder()
    .withName("Jane Doe")
    .withId("SE123")
    .withDepartment("Engineering")
    .withTitle(SoftwareEngineerTitle.SENIOR)
    .build();
