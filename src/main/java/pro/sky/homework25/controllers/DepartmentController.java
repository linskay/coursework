package pro.sky.homework25.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pro.sky.homework25.Employee;
import pro.sky.homework25.service.DepartmentServiceImpl;
import pro.sky.homework25.service.EmployeeService;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}/employees")
    public Collection<Employee> getEmployeesByDepartment(@PathVariable Integer id) {
        return departmentService.employeesDepartment(id);
    }

    @GetMapping("/{id}/max-salary")
    public int maxSalaryDepartment(@PathVariable Integer id) {
        return departmentService.getEmployeeWithMaxSalary(id);
    }

    @GetMapping("/{id}/min-salary")
    public int minSalaryDepartment(@PathVariable Integer id) {
        return departmentService.getEmployeeWithMinSalary(id);
    }

    @GetMapping("/{id}/salary/sum")
    public int getSalariesSumByDepartment(@PathVariable Integer id) {
        return departmentService.getSalariesSumByDepartment(id);
    }

    @GetMapping(path = "/employees")
    public Map<Integer, List<Employee>> getEmployeesByGroupDepartment() {
        return departmentService.allEmployeesDepartments();
    }
}
