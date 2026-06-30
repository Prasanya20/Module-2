class Employee {
    int employeeId;
    String name;
    String position;
    double salary;

    public Employee(int employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        System.out.println("ID: " + employeeId +
                ", Name: " + name +
                ", Position: " + position +
                ", Salary: Rs." + salary);
    }
}

public class Main {

    static Employee[] employees = new Employee[10];
    static int count = 0;

    public static void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Employee Added.");
        } else {
            System.out.println("Employee Array is Full.");
        }
    }

    public static void searchEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {
                System.out.println("Employee Found:");
                employees[i].display();
                return;
            }
        }
        System.out.println("Employee Not Found.");
    }

    public static void traverseEmployees() {
        System.out.println("\nEmployee Records:");
        for (int i = 0; i < count; i++) {
            employees[i].display();
        }
    }

    public static void deleteEmployee(int id) {
        for (int i = 0; i < count; i++) {
            if (employees[i].employeeId == id) {

                for (int j = i; j < count - 1; j++) {
                    employees[j] = employees[j + 1];
                }

                employees[count - 1] = null;
                count--;

                System.out.println("Employee Deleted.");
                return;
            }
        }
        System.out.println("Employee Not Found.");
    }

    public static void main(String[] args) {

        addEmployee(new Employee(101, "Usha", "Manager", 50000));
        addEmployee(new Employee(102, "Rani", "Developer", 40000));
        addEmployee(new Employee(103, "Rahul", "Tester", 35000));

        traverseEmployees();

        System.out.println();
        searchEmployee(102);

        System.out.println();
        deleteEmployee(102);

        traverseEmployees();
    }
}
