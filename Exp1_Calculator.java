
import java.util.*;

class all {
    int a, b;

    void add() {
        System.out.println("Addition of two numbers: " + (a + b));
    }

    void sub() {
        System.out.println("Subtraction of two numbers: " + (a - b));
    }

    void multi() {
        System.out.println("Multiplication of two numbers: " + (a * b));
    }

    void div() {
        try {
            System.out.println("Division of two numbers: " + (a / b));
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero");
        }
    }

    void display() {
        Scanner sc = new Scanner(System.in);
        String c, ch="y";

        do {
            try {
                System.out.print("Enter First Number: ");
                a = sc.nextInt();

                System.out.print("Enter Second Number: ");
                b = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Only numbers are allowed");
                sc.next();
                continue;
            }

            System.out.println("Enter operation (+, -, *, /): ");
            c = sc.next();

            switch (c) {
                case "+":
                    add();
                    break;
                case "-":
                    sub();
                    break;
                case "*":
                    multi();
                    break;
                case "/":
                    div();
                    break;
                default:
                    System.out.println("Invalid operator");
            }

            System.out.print("Calculate again? (Y/N): ");
            ch = sc.next();

        } while (ch.equalsIgnoreCase("y"));

        System.out.println("Thank you!");
        
        sc.close();
    }
}

public class Exp1_Calculator {
    public static void main(String[] args) {
        all a = new all();
        a.display();
    }
}
