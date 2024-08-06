package pro.sky.homework25.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("Сотрудник уже добавлен");
    }

    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
