package pro.sky.homework25;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.homework25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework25.exceptions.EmployeeNotFoundException;
import pro.sky.homework25.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<Employee> addEmployee(@RequestParam("firstName") String firstName,
                                                @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            return ResponseEntity.ok(employee);
        } catch (EmployeeStorageIsFullException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(path = "/remove")
    public ResponseEntity<Employee> removeEmployee(@RequestParam("firstName") String firstName,
                                                   @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping(path = "/find")
    public ResponseEntity<Employee> findEmployee(@RequestParam("firstName") String firstName,
                                                 @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeService.addEmployee(firstName, lastName);
            return ResponseEntity.ok(employee);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeService.findAll();
    }
}

