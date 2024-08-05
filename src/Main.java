public class Main {
    public Employee[] employees;

    public Main() {
        employees = new Employee[10];
        initializeEmployees();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.printEmployees();
        System.out.println("Общая сумма затрат на ЗП в месяц: " + main.getTotalSalary());
        System.out.println("Сотрудник с минимальной ЗП: " + main.getEmployeeWithMinSalary());
        System.out.println("Сотрудник с максимальной ЗП: " + main.getEmployeeWithMaxSalary());
        System.out.println("Средняя ЗП в месяц: " + main.totalMonthlyAverageSalary());
        System.out.println("Список сотрудников:");
        main.printEmployeesFullNames();
    }

    public void initializeEmployees() {
        employees[0] = createEmployee("Константин", "Маласаев", "ЭтоНикита", 50_000, 2);
        employees[1] = createEmployee("Андрей", "Шелков", "ЭтоСтас", 35_000, 1);
        employees[2] = createEmployee("Дмитрий", "Вьюшкин", "ЭтоГена", 48_000, 5);
        employees[3] = createEmployee("Сергей", "Гореликов", "ЭтоТурбо", 64_000, 4);
        employees[4] = createEmployee("Андрей", "Минин", "ЭтоДюшаМетелкин", 58_000, 3);
        employees[5] = createEmployee("Гарольд", "Скрывающий", "Боль", 100_000, 5);
        employees[6] = createEmployee("Джордан", "Потеющий", "Пил", 84_000, 4);
        employees[7] = createEmployee("Боб", "Спанч", "Сквепенс", 77_000, 2);
        employees[8] = createEmployee("Это", "Нет", "Патрик", 92_000, 3);
        employees[9] = createEmployee("Это", "Вот", "Поворот", 300_000, 2);
    }

    public Employee createEmployee(String name, String surname, String patronymic, int salary, int department) {
        return new Employee(name, surname, patronymic, salary, department);
    }

    public void printEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
    public int getTotalSalary() {
        int totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.getSalary();
        }
        return totalSalary;
}
        public Employee getEmployeeWithMinSalary() {
            Employee minSalaryEmployee = employees[0];
            for (Employee employee : employees) {
                if (employee.getSalary() < minSalaryEmployee.getSalary()) {
                    minSalaryEmployee = employee;
                }
            }
            return minSalaryEmployee;
        }

       public Employee getEmployeeWithMaxSalary () {
           Employee employeeWithMaxSalary = employees[0];
           for (Employee employee : employees) {
               if (employee.getSalary() > employeeWithMaxSalary.getSalary()) {
                   employeeWithMaxSalary = employee;
               }
           }
           return employeeWithMaxSalary;
       }


        public int totalMonthlyAverageSalary () {
            int totalMonthlyAverageSalary = getTotalSalary() / employees.length;
            return totalMonthlyAverageSalary;
        }

    public void printEmployeesFullNames() {
        int counter = 1;
        for (Employee employee : employees) {
            System.out.println(counter + ". " + employee.getSurname() + " " + employee.getName()+ " " + employee.getPatronymic());
            counter++;
        }
    }
  }