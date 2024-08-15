package pro.sky.homework25;

import org.springframework.stereotype.Service;
import pro.sky.homework25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework25.exceptions.EmployeeNotFoundException;
import pro.sky.homework25.exceptions.EmployeeStorageIsFullException;

import java.util.*;

@Service
public class EmployeeService {
    private final int MAX_EMPLOYEES = 20;
    private Map<String, Employee> employees;

    public EmployeeService() {

        this.employees = new HashMap<>();
        new Employee("Костя", "Маласаев");
        new Employee("Андрюха", "Шелков");
        new Employee("Димон", "Вьюшкин");
        new Employee("Серега", "Гореликов");
        new Employee("АндрейКа", "Минин");
        new Employee("Никита", "Мемасиков");
        new Employee("Стас", "Выжил");
        new Employee("Гена", "СпанчБобский");
        new Employee("Турбо", "Джавович");
        new Employee("Дюша", "Кофеинов");
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= MAX_EMPLOYEES) {
            throw new EmployeeStorageIsFullException("Зарплаты на всех не хватит, макс. кол-во сотрудников - " + MAX_EMPLOYEES);
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullame())) {
            throw new EmployeeAlreadyAddedException("Этот " + firstName + " " + lastName + " сотрудник уже есть");
        }
        employees.put(employee.getFullame(), employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullame())) {
            return employees.remove(employee.getFullame());
        }
        throw new EmployeeNotFoundException("Такого сотрудника " + firstName + " " + lastName + " нет в базе, увы");
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.containsKey(employee.getFullame())) {
            throw new EmployeeNotFoundException("Такого сотрудника " + firstName + " " + lastName + " нет в базе, увы");
        }
        return employees.get(employee.getFullame());
    }


    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }
}