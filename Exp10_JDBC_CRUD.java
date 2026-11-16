import java.sql.*;
import java.util.Scanner;

public class Exp10_JDBC_CRUD {

    static final String URL = "jdbc:mysql://localhost:3306/college";
    static final String USER = "root";
    static final String PASSWORD = "root";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            // Establish database connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Disable auto-commit
            con.setAutoCommit(false);

            System.out.println("Database Connected Successfully!");

            int choice;

            do {
                System.out.println("\n--- Student Management System ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                choice = sc.nextInt();

                try {
                    switch (choice) {

                        // CREATE
                        case 1:
                            System.out.print("Enter ID: ");
                            int id = sc.nextInt();

                            sc.nextLine();
                            System.out.print("Enter Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Course: ");
                            String course = sc.nextLine();

                            System.out.print("Enter Marks: ");
                            double marks = sc.nextDouble();

                            String insert = "INSERT INTO student VALUES (?, ?, ?, ?)";
                            PreparedStatement ps1 = con.prepareStatement(insert);

                            ps1.setInt(1, id);
                            ps1.setString(2, name);
                            ps1.setString(3, course);
                            ps1.setDouble(4, marks);

                            ps1.executeUpdate();
                            con.commit();

                            System.out.println("Student Inserted Successfully!");
                            ps1.close();
                            break;

                        // READ
                        case 2:
                            String select = "SELECT * FROM student";
                            PreparedStatement ps2 = con.prepareStatement(select);

                            ResultSet rs = ps2.executeQuery();

                            System.out.println("\nID\tName\tCourse\tMarks");

                            while (rs.next()) {
                                System.out.println(
                                    rs.getInt("id") + "\t" +
                                    rs.getString("name") + "\t" +
                                    rs.getString("course") + "\t" +
                                    rs.getDouble("marks")
                                );
                            }

                            rs.close();
                            ps2.close();
                            break;

                        // UPDATE
                        case 3:
                            System.out.print("Enter Student ID to update: ");
                            int uid = sc.nextInt();

                            sc.nextLine();
                            System.out.print("Enter New Name: ");
                            String newName = sc.nextLine();

                            System.out.print("Enter New Course: ");
                            String newCourse = sc.nextLine();

                            System.out.print("Enter New Marks: ");
                            double newMarks = sc.nextDouble();

                            String update = "UPDATE student SET name=?, course=?, marks=? WHERE id=?";
                            PreparedStatement ps3 = con.prepareStatement(update);

                            ps3.setString(1, newName);
                            ps3.setString(2, newCourse);
                            ps3.setDouble(3, newMarks);
                            ps3.setInt(4, uid);

                            int updated = ps3.executeUpdate();
                            con.commit();

                            if (updated > 0)
                                System.out.println("Student Updated Successfully!");
                            else
                                System.out.println("Student ID Not Found!");

                            ps3.close();
                            break;

                        // DELETE
                        case 4:
                            System.out.print("Enter Student ID to delete: ");
                            int did = sc.nextInt();

                            String delete = "DELETE FROM student WHERE id=?";
                            PreparedStatement ps4 = con.prepareStatement(delete);

                            ps4.setInt(1, did);

                            int deleted = ps4.executeUpdate();
                            con.commit();

                            if (deleted > 0)
                                System.out.println("Student Deleted Successfully!");
                            else
                                System.out.println("Student ID Not Found!");

                            ps4.close();
                            break;

                        case 5:
                            System.out.println("Exiting Program...");
                            break;

                        default:
                            System.out.println("Invalid Choice!");
                    }

                } catch (SQLException e) {
                    con.rollback();
                    System.out.println("Operation Failed: " + e.getMessage());
                }

            } while (choice != 5);

            con.close();

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        sc.close();
    }
}
// Tasks:
// 1. Connect Java application to MySQL using JDBC.
// 2. Disable auto-commit for transaction management.
// 3. Insert student records using PreparedStatement.
// 4. Display student records using ResultSet.
// 5. Update student records using student ID.
// 6. Delete student records using student ID.
// 7. Use commit() to save transactions.
// 8. Use rollback() to handle errors.
// 9. Close database resources.