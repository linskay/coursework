package pro.sky.homework25.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException {
    public EmployeeStorageIsFullException() {
        super("Слишком много людей в базе, увольте кого-нибудь");
    }

    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}