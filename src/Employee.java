import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String patronymic;
    private int salary;
    private int department;
    private int id;
    private static int nextId = 1;

    public Employee(String name, String surname, String patronymic, int salary, int department) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.salary = salary;
        this.department = department;
        this.id = nextId++;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getSalary() {
        return (int) salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Зарплата не может быть отрицательной.");
        }
        this.salary = salary;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        if (department < 1 || department > 5) {
            throw new IllegalArgumentException("Недопустимый номер отдела. Должно быть от 1 до 5.");
        }
        this.department = department;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id &&
                department == employee.department &&
                Double.compare(employee.salary, salary) == 0 &&
                Objects.equals(surname, employee.surname) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(patronymic, employee.patronymic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, patronymic, department, salary);
    }

    @Override
    public String toString() {
        return "id " + id +
                ", ФИО " + surname + " " + name + " " + patronymic +
                ", отдел " + department + ", зарплата" + " " + salary;
    }
}