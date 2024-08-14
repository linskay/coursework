package pro.sky.homework25;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.homework25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework25.exceptions.EmployeeNotFoundException;
import pro.sky.homework25.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;

import static sun.jvm.hotspot.HelloWorld.e;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<String> addEmployee(@RequestParam("firstName") String firstName,
                                              @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            return ResponseEntity.ok("Сотрудник " + firstName + " " + lastName + " добавлен");
        } catch (EmployeeStorageIsFullException e) {
            throw e;
        } catch (EmployeeAlreadyAddedException e) {
            throw e;
        }
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        try {
            employeeService.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw e;
        }
        return employeeService.removeEmployee(firstName, lastName);
    }

    @GetMapping(path = "/find1")
    public ResponseEntity<String> findEmployee(@RequestParam("firstName") String firstName,
                                               @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            return ResponseEntity.ok("Сотрудник " + firstName + " " + lastName + " найден");
        } catch (EmployeeNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        try {
            employeeService.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник " + firstName + " " + lastName + " не найден");
            throw e;
        }
        return employeeService.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}

