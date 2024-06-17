import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        employees[0] = new Employee("Константин", "Маласаев", "ЭтоНикита", 50_000, 2);
        employees[1] = new Employee("Андрей", "Шелков", "ЭтоСтас", 35_000, 1);
        employees[2] = new Employee("Дмитрий", "Вьюшкин", "ЭтоГена", 48_000, 5);
        employees[3] = new Employee("Сергей", "Гореликов", "ЭтоТурбо", 64_000, 4);
        employees[4] = new Employee("Андрей", "Минин", "ЭтоДюшаМетелкин", 58_000, 3);
        employees[5] = new Employee("Гарольд", "Скрывающий", "Боль", 100_000, 5);
        employees[6] = new Employee("Джордан", "Потеющий", "Пил", 84_000, 4);
        employees[7] = new Employee("Боб", "Спанч", "Сквепенс", 77_000, 2);
        employees[8] = new Employee("Это", "Нет", "Патрик", 92_000, 3);
        employees[9] = new Employee("Это", "Вот", "Поворот", 300_000, 2);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        int totalMonthlyExpenses = 0;
        for (Employee employee : employees) {
            totalMonthlyExpenses += employee.getSalary();
        }

        System.out.println("Общая сумма затрат на ЗП в месяц: " + totalMonthlyExpenses);

        Employee employeeWithMinSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() < employeeWithMinSalary.getSalary()) {
                employeeWithMinSalary = employee;
            }
        }

        System.out.println("Сотрудник с минимальной ЗП: " + employeeWithMinSalary);

        Employee employeeWithMaxSalary = employees[0];
        for (Employee employee : employees) {
            if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                employeeWithMaxSalary = employee;
            }
        }

        System.out.println("Сотрудник с максимальной ЗП: " + employeeWithMaxSalary);

        int totalMonthlyAverageSalary = totalMonthlyExpenses / employees.length;

        System.out.println("Средняя ЗП в месяц: " + totalMonthlyAverageSalary);

        System.out.println("Список сотрудников:");
        int counter = 1;
        for (Employee employee : employees) {
            System.out.println(counter + ". " + employee.getSurname() + " " + employee.getName() + " " + employee.getPatronymic());
            counter++;

        }
    }
}
