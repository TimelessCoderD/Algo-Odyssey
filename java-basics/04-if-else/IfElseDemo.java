import java.util.Scanner;

public class IfElseDemo {

    public static void main(String[] args) {

        // Run these one by one while learning.
        checkVotingEligibility();
        evenOrOdd();
        positiveNegativeZero();
        greatestOfTwo();
        greatestOfThree();
        triangleType();
        gradeCalculator();
        leapYear();
        multipleConditions();
        variableScope();
    }

    // Program 1: Simple if
    static void checkVotingEligibility() {
        System.out.println("\n=== 1. Voting Eligibility ===");

        int age = 20;

        if (age >= 18) {
            System.out.println("You can vote");
        }
    }

    // Program 2: if-else
    static void evenOrOdd() {
        System.out.println("\n=== 2. Even or Odd ===");

        int num = 10;

        if (num % 2 == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }

    // Program 3: else-if ladder
    static void positiveNegativeZero() {
        System.out.println("\n=== 3. Positive / Negative / Zero ===");

        int num = -5;

        if (num > 0) {
            System.out.println("Positive");
        } else if (num < 0) {
            System.out.println("Negative");
        } else {
            System.out.println("Zero");
        }
    }

    // Program 4: Greatest of two numbers
    static void greatestOfTwo() {
        System.out.println("\n=== 4. Greatest of Two ===");

        int a = 25;
        int b = 18;

        if (a > b) {
            System.out.println(a + " is greater");
        } else if (b > a) {
            System.out.println(b + " is greater");
        } else {
            System.out.println("Both are equal");
        }
    }

    // Program 5: Greatest of three numbers
    static void greatestOfThree() {
        System.out.println("\n=== 5. Greatest of Three ===");

        int a = 25;
        int b = 40;
        int c = 30;

        if (a >= b && a >= c) {
            System.out.println("Greatest = " + a);
        } else if (b >= a && b >= c) {
            System.out.println("Greatest = " + b);
        } else {
            System.out.println("Greatest = " + c);
        }
    }

    // Program 6: Triangle classification
    static void triangleType() {
        System.out.println("\n=== 6. Triangle Type ===");

        int a = 5;
        int b = 5;
        int c = 8;

        if (a == b && b == c) {
            System.out.println("Equilateral");
        } else if (a == b || a == c || b == c) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }
    }

    // Program 7: Grade calculator
    static void gradeCalculator() {
        System.out.println("\n=== 7. Grade Calculator ===");

        int marks = 82;

        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else if (marks >= 40) {
            System.out.println("Grade D");
        } else {
            System.out.println("Fail");
        }
    }

    // Program 8: Leap year
    static void leapYear() {
        System.out.println("\n=== 8. Leap Year ===");

        int year = 2028;

        if (year % 400 == 0) {
            System.out.println("Leap year");
        } else if (year % 100 == 0) {
            System.out.println("Not a leap year");
        } else if (year % 4 == 0) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }

    // Program 9: Nested if + logical operators
    static void multipleConditions() {
        System.out.println("\n=== 9. Multiple Conditions ===");

        int age = 25;
        boolean hasId = true;

        if (age >= 18) {
            if (hasId) {
                System.out.println("Entry allowed");
            } else {
                System.out.println("ID required");
            }
        } else {
            System.out.println("Not eligible");
        }

        // Equivalent style using &&:
        if (age >= 18 && hasId) {
            System.out.println("Eligible using &&");
        }
    }

    // Program 10: Variable scope
    static void variableScope() {
        System.out.println("\n=== 10. Variable Scope ===");

        int outer = 10;

        if (outer > 0) {
            int inner = 20;

            System.out.println("Outer = " + outer);
            System.out.println("Inner = " + inner);
        }

        // 'inner' cannot be accessed here.
        // System.out.println(inner); // Compilation error

        System.out.println("Outer is still accessible = " + outer);
    }
}
