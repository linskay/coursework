package pro.sky.homework25;

import org.springframework.stereotype.Service;
import pro.sky.homework25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework25.exceptions.EmployeeNotFoundException;
import pro.sky.homework25.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private final int MAX_EMPLOYEES = 20;
    private List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>(Arrays.asList(
                new Employee("Костя", "Маласаев"),
                new Employee("Андрюха", "Шелков"),
                new Employee("Димон", "Вьюшкин"),
                new Employee("Серега", "Гореликов"),
                new Employee("АндрейКа", "Минин"),
                new Employee("Никита", "Мемасиков"),
                new Employee("Стас", "Выжил"),
                new Employee("Гена", "СпанчБобский"),
                new Employee("Турбо", "Джавович"),
                new Employee("Дюша", "Кофеинов")
        ));
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Зарплаты на всех не хватит, макс. кол-во сотрудников - " + MAX_EMPLOYEES);
        }
        for (Employee employee : employees) {
            if (employee.equals(new Employee(firstName, lastName))) {
                throw new EmployeeAlreadyAddedException("Этот " + firstName + " " + lastName + " сотрудник уже есть");
            }
        }
        employees.add(new Employee(firstName, lastName));
        return null;
    }

    public void removeEmployee(String firstName, String lastName) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).equals(new Employee(firstName, lastName))) {
                employees.remove(i);
                return;
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника " + firstName + " " + lastName + " нет в базе, увы");
    }

    public Optional<Employee> findEmployee(String firstName, String lastName) {
        for (Employee employee : employees) {
            if (employee.equals(new Employee(firstName, lastName))) {
                return Optional.of(employee);
            }
        }
        throw new EmployeeNotFoundException("Такого сотрудника " + firstName + " " + lastName + " нет в базе, увы");
    }

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public Collection<Employee> findAll() {
        return Collections.unmodifiableList(employees);
    }
}