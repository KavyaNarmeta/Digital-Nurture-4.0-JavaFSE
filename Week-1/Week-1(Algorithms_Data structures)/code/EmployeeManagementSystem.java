class Employee {
    String employeeId;
    String name;
    String position;
    double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String toString() {
        return employeeId + " - " + name + " | Position: " + position + " | Salary: $" + salary;
    }
}

public class EmployeeManagementSystem {
    private static final int MAX = 100;
    private Employee[] employees = new Employee[MAX];
    private int size = 0;

    public void addEmployee(Employee emp) {
        if (size < MAX) {
            employees[size++] = emp;
        }
    }

    public Employee searchEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(id)) {
                return employees[i];
            }
        }
        return null;
    }

    public void deleteEmployee(String id) {
        for (int i = 0; i < size; i++) {
            if (employees[i].employeeId.equals(id)) {
                for (int j = i; j < size - 1; j++) {
                    employees[j] = employees[j + 1];
                }
                employees[--size] = null;
                return;
            }
        }
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        ems.addEmployee(new Employee("E001", "John", "Manager", 75000));
        ems.addEmployee(new Employee("E002", "Jane", "Developer", 65000));

        ems.traverseEmployees();
        System.out.println("Searching for E002: " + ems.searchEmployee("E002"));

        ems.deleteEmployee("E001");
        ems.traverseEmployees();
    }
}
