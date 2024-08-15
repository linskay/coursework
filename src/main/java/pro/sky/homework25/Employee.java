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
        return firstName + " " + lastName;
    }

    public String getSurname() {
        return lastName;
    }

    public String getFullame() {
        return lastName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return firstName.equals(other.firstName) && lastName.equals(other.lastName);
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
