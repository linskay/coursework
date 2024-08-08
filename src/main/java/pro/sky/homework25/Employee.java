package pro.sky.homework25;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;

    public Employee(String name, String surname) {
        this.firstName = name;
        this.lastName = surname;
    }

    public String getName() {
        return firstName;
    }

    public String getSurname() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(lastName, employee.lastName) &&
                Objects.equals(firstName, employee.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "ФИ: " + lastName + " " + firstName;
    }
}
