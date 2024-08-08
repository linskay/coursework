package pro.sky.homework25.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException() {
        super("Сотрудник не найден");
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
