
import java.util.*;

// Academic interface
interface Academic {
    void StoreAcademicDetails();
    void DisplayAcademicDetails();
}

// Sports interface
interface Sports {
    void StoreSportsDetails();
    void DisplaySportsDetails();
}

// Student implements both interfaces
class Student implements Academic, Sports {
    String name, course, sport, achievement;
    int rollno;
    double percentage;

    Scanner sc = new Scanner(System.in);

    // Store academic details
    public void StoreAcademicDetails() {
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();

        System.out.print("Enter Roll Number: ");
        rollno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Course Name: ");
        course = sc.nextLine();

        System.out.print("Enter Student Percentage: ");
        percentage = sc.nextDouble();
        sc.nextLine();
    }

    // Display academic details
    public void DisplayAcademicDetails() {
        System.out.println("\nAcademic Details");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollno);
        System.out.println("Course Name: " + course);
        System.out.println("Percentage: " + percentage);
    }

    // Store sports details
    public void StoreSportsDetails() {
        System.out.print("\nEnter Sport Name: ");
        sport = sc.nextLine();

        System.out.print("Enter Sport Achievement: ");
        achievement = sc.nextLine();
    }

    // Display sports details
    public void DisplaySportsDetails() {
        System.out.println("\nSports Details");
        System.out.println("Sport: " + sport);
        System.out.println("Achievement: " + achievement);
    }
}

public class Exp6_Interfaces {
    public static void main(String[] args) {
        Student s = new Student();

        s.StoreAcademicDetails();
        s.DisplayAcademicDetails();

        s.StoreSportsDetails();
        s.DisplaySportsDetails();
    }
}
