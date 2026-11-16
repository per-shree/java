
import java.util.*;

class Matrix {
    int r, c;
    Scanner sc = new Scanner(System.in);

    // Accept matrix elements
    int[][] read() {
        System.out.print("Enter rows: ");
        r = sc.nextInt();

        System.out.print("Enter columns: ");
        c = sc.nextInt();

        // Validate dimensions
        while (r <= 0 || c <= 0) {
            System.out.println("Rows and columns must be positive.");
            System.out.print("Enter rows: ");
            r = sc.nextInt();
            System.out.print("Enter columns: ");
            c = sc.nextInt();
        }

        int[][] m = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                m[i][j] = sc.nextInt();
            }
        }
        return m;
    }

    // Display matrix
    void display(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + "\t");
            }
            System.out.println();
        }
    }

    // Matrix addition
    int[][] add(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            System.out.println("Addition not possible.");
            return new int[0][0];
        }

        int[][] result = new int[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    // Matrix multiplication
    int[][] multiply(int[][] a, int[][] b) {
        if (a[0].length != b.length) {
            System.out.println("Multiplication not possible.");
            return new int[0][0];
        }

        int[][] result = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Matrix transpose
    int[][] transpose(int[][] a) {
        int[][] t = new int[a[0].length][a.length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                t[j][i] = a[i][j];
            }
        }
        return t;
    }

    // Calculate row-wise sum
    void rowAddition(int[][] a) {
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = 0; j < a[0].length; j++) {
                sum += a[i][j];
            }
            System.out.println("Row " + (i + 1) + " sum = " + sum);
        }
    }

    // Calculate column-wise sum
    void columnAddition(int[][] a) {
        for (int j = 0; j < a[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < a.length; i++) {
                sum += a[i][j];
            }
            System.out.println("Column " + (j + 1) + " sum = " + sum);
        }
    }
}

public class Exp3_2D_Array {
    public static void main(String[] args) {
        Matrix obj = new Matrix();

        // Read and display first matrix
        System.out.println("Enter Matrix One:");
        int[][] a = obj.read();
        System.out.println("Matrix One:");
        obj.display(a);

        // Read and display second matrix
        System.out.println("\nEnter Matrix Two:");
        int[][] b = obj.read();
        System.out.println("Matrix Two:");
        obj.display(b);

        int choice;

        // Menu-driven operations
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Addition");
            System.out.println("2. Multiplication");
            System.out.println("3. Transpose of Matrix One");
            System.out.println("4. Row-wise Sum of Matrix One");
            System.out.println("5. Column-wise Sum of Matrix One");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = obj.sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Addition:");
                    int[][] sum = obj.add(a, b);
                    if (sum.length > 0)
                        obj.display(sum);
                    break;

                case 2:
                    System.out.println("Multiplication:");
                    int[][] product = obj.multiply(a, b);
                    if (product.length > 0)
                        obj.display(product);
                    break;

                case 3:
                    System.out.println("Transpose:");
                    obj.display(obj.transpose(a));
                    break;

                case 4:
                    obj.rowAddition(a);
                    break;

                case 5:
                    obj.columnAddition(a);
                    break;

                case 6:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 6);

        obj.sc.close();
    }
}
