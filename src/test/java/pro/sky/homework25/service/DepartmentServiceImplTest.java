package pro.sky.homework25.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.homework25.Employee;
import pro.sky.homework25.exceptions.EmployeeNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.Collections.EMPTY_LIST;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    private static final Random RANDOM = new Random();
    private static final Collection<Employee> employeeList = List.of(
            new Employee("ддд1", "ввв", 10000, 1),
            new Employee("ддд2", "ввв", 11000, 2),
            new Employee("ддд3", "ввв", 12000, 3),
            new Employee("ддд4", "ввв", 13000, 4),
            new Employee("ддд5", "ввв", 14000, 4),
            new Employee("ддд6", "ввв", 15000, 1),
            new Employee("ддд7", "ввв", 16000, 2),
            new Employee("ддд8", "ввв", 17000, 3),
            new Employee("ддд9", "ввв", 18000, 4),
            new Employee("ддд10", "ввв", 19000, 4),
            new Employee("ддд11", "ввв", 20000, 1),
            new Employee("ддд12", "ввв", 11000, 2),
            new Employee("ддд13", "ввв", 12000, 3),
            new Employee("ддд14", "ввв", 13000, 4),
            new Employee("ддд15", "ввв", 14000, 4),
            new Employee("ддд16", "ввв", 15000, 1),
            new Employee("ддд17", "ввв", 16000, 2),
            new Employee("ддд18", "ввв", 17000, 3),
            new Employee("ддд19", "ввв", 18000, 4),
            new Employee("ддд20", "ввв", 18000, 5)
    );

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    @DisplayName("Положительный тест на получение сотрудников по департаменту")
    @Test
    void addEmployeeByDepartmentTest() {

        int requestDepartment = 1;
        when(employeeService.findAll())
                .thenReturn(employeeList);

        Collection<Employee> expected = employeeList.stream()
                .filter(employee -> employee.getDepartment() == requestDepartment)
                .toList();

        Collection<Employee> actual = departmentService.employeesDepartment(requestDepartment);
        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    @DisplayName("Негативный тест на получение сотрудников по департаменту из несуществующего отдела")
    @Test
    void addEmployeeByDepartmentTestNegative() {

        int requestDepartment = 100;
        when(employeeService.findAll()).
                thenReturn(employeeList);

        Collection<Employee> actual = departmentService.employeesDepartment(requestDepartment);

        verify(employeeService, times(1)).findAll();
        assertTrue(actual.isEmpty());
    }

    @DisplayName("Негативный тест на получение сотрудников по департаменту с пустым хранилищем")
    @Test
    void addEmployeeByDepartmentTestNegativeNull() {

        int requestDepartment = 1;
        when(employeeService.findAll()).
                thenReturn(EMPTY_LIST);

        Collection<Employee> actual = departmentService.employeesDepartment(requestDepartment);

        verify(employeeService, times(1)).findAll();
        assertTrue(actual.isEmpty());
    }

    @DisplayName("Положительный тест на получение суммы зарплат по департаменту")
    @ParameterizedTest
    @MethodSource("provideDataForSum")
    void getSalaryEmployeeByDepartmentTest(int departmentId, int expected) {

        when(employeeService.findAll())
                .thenReturn(employeeList);

        int actual = departmentService.getSalariesSumByDepartment(departmentId);

        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideDataForSum() {
        return Stream.of(
                Arguments.arguments(1, 60000),
                Arguments.arguments(100, 0),
                Arguments.arguments(5, 18000)
        );
    }

    @DisplayName("Положительный тест на получение максимальной зп по департаменту")
    @ParameterizedTest
    @MethodSource("provideDataForMax")
    void getMaxSalaryEmployeeByDepartmentTest(int departmentId, int expected) {

        when(employeeService.findAll())
                .thenReturn(employeeList);

        int actual = departmentService.getEmployeeWithMaxSalary(departmentId);

        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideDataForMax() {
        return Stream.of(
                Arguments.arguments(1, 20000),
                Arguments.arguments(2, 16000),
                Arguments.arguments(5, 18000)
        );
    }

    @DisplayName("Негативный тест на получение максимальной зп по департаменту")
    @Test
    void getMaxSalaryEmployeeByDepartmentNegativeTest() {

        int requestDepartmentID = 100;
        when(employeeService.findAll())
                .thenReturn(employeeList);

        assertThrows(EmployeeNotFoundException.class, () ->
                departmentService.getEmployeeWithMaxSalary(requestDepartmentID));
        verify(employeeService, times(1)).findAll();
    }

    @DisplayName("Положительный тест на получение минимальной зп по департаменту")
    @ParameterizedTest
    @MethodSource("provideDataForMin")
    void getMinSalaryEmployeeByDepartmentTest(int departmentId, int expected) {

        when(employeeService.findAll())
                .thenReturn(employeeList);

        int actual = departmentService.getEmployeeWithMinSalary(departmentId);

        verify(employeeService, times(1)).findAll();
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideDataForMin() {
        return Stream.of(
                Arguments.arguments(1, 10000),
                Arguments.arguments(2, 11000),
                Arguments.arguments(5, 18000)
        );
    }

    @DisplayName("Негативный тест на получение минимальной зп по департаменту")
    @Test
    void getMinSalaryEmployeeByDepartmentNegativeTest() {

        int requestDepartmentID = 100;
        when(employeeService.findAll())
                .thenReturn(employeeList);

        assertThrows(EmployeeNotFoundException.class, () ->
                departmentService.getEmployeeWithMinSalary(requestDepartmentID));
        verify(employeeService, times(1)).findAll();
    }
}
