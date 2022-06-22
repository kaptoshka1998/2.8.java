package pro.sky28.java;

import java.util.Objects;

public class Employee {

    private String firstName;
    private String lastName;
    private String department;
    private int salary;

    public Employee(String firstName, String lastName, int salary, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getEmployeeSalary() {
        return this.salary;
    }

    public String getEmployeeDepartment() {
        return this.department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return salary == employee.salary && firstName.equals(employee.firstName) && lastName.equals(employee.lastName) && department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, department, salary);
    }
}
