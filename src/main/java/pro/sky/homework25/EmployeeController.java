package pro.sky.homework25;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pro.sky.homework25.exceptions.EmployeeAlreadyAddedException;
import pro.sky.homework25.exceptions.EmployeeNotFoundException;
import pro.sky.homework25.exceptions.EmployeeStorageIsFullException;

import java.util.Collection;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private EmployeeServiceImpl employeeServiceImpl;

    public EmployeeController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping(path = "/add")
    public ResponseEntity<String> addEmployee(@RequestParam("firstName") String firstName,
                                              @RequestParam("lastName") String lastName) {
        try {
            Employee employee = employeeServiceImpl.addEmployee(firstName, lastName);
            return ResponseEntity.ok("Сотрудник " + firstName + " " + lastName + " добавлен");
        } catch (EmployeeStorageIsFullException e) {
            throw e;
        } catch (EmployeeAlreadyAddedException e) {
            throw e;
        }
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        try {
            return employeeServiceImpl.removeEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        try {
            employeeServiceImpl.findEmployee(firstName, lastName);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник " + firstName + " " + lastName + " не найден");
            throw e;
        }
        return employeeServiceImpl.findEmployee(firstName, lastName);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return employeeServiceImpl.findAll();
    }
}
