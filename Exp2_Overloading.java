
class Employee {
    int id;
    String name;
    double salary;

    // Default constructor
    Employee() {
        id = 0;
        name = "Unknown";
        salary = 0.0;
    }

    // Constructor with name only
    Employee(String name) {
        this.name = name;
        id = 0;
        salary = 0.0;
    }

    // Constructor with name and salary
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        id = 0;
    }

    // Constructor with all details
    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Employee Salary: " + salary);
        System.out.println("Annual Salary: " + (salary * 12));
        System.out.println();
    }
}

public class Exp2_Overloading {
    public static void main(String[] args) {
        Employee e1 = new Employee();
        Employee e2 = new Employee("Sujal");
        Employee e3 = new Employee("Tirth", 30000);
        Employee e4 = new Employee(158, "SK", 40000);

        System.out.println("Default Constructor");
        e1.display();

        System.out.println("Constructor with Name Only");
        e2.display();

        System.out.println("Constructor with Name and Salary");
        e3.display();

        System.out.println("Constructor with All Details");
        e4.display();
    }
}
