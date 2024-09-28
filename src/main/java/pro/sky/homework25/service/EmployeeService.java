package pro.sky.homework25.service;

import pro.sky.homework25.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface EmployeeService {


    Employee addEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee removeEmployee(String firstName, String lastName, Integer salary, Integer department);

    Employee findEmployee(String firstName, String lastName, Integer salary, Integer department);

    Collection<Employee> findAll();

    Map<Integer, List<Employee>> allEmployeesDepartments();

    int getTotalSalary();
}
