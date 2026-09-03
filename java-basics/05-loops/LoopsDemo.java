public class LoopsDemo {

    public static void main(String[] args) {

        print1To5();
        print5To1();
        sum1ToN();
        extractDigits();
        breakExample();
        continueExample();
        printFactors();
        gcdExample();
        lcmExample();
        starPattern();
    }

    // Program 1: Print 1 to 5 using while
    static void print1To5() {
        System.out.println("\n=== 1. Print 1 to 5 ===");

        int n = 1;

        while (n <= 5) {
            System.out.println(n);
            n++;
        }
    }

    // Program 2: Print 5 to 1 using while
    static void print5To1() {
        System.out.println("\n=== 2. Print 5 to 1 ===");

        int n = 5;

        while (n >= 1) {
            System.out.println(n);
            n--;
        }
    }

    // Program 3: Sum from 1 to N using for
    static void sum1ToN() {
        System.out.println("\n=== 3. Sum from 1 to N ===");

        int n = 5;
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Sum = " + sum);
    }

    // Program 4: Extract digits from a number
    static void extractDigits() {
        System.out.println("\n=== 4. Extract Digits ===");

        int n = 6487;

        while (n > 0) {
            int digit = n % 10;
            System.out.println(digit);
            n /= 10;
        }
    }

    // Program 5: break
    static void breakExample() {
        System.out.println("\n=== 5. Break Example ===");

        for (int i = 1; i <= 10; i++) {

            if (i == 5) {
                break;
            }

            System.out.println(i);
        }
    }

    // Program 6: continue
    static void continueExample() {
        System.out.println("\n=== 6. Continue Example ===");

        for (int i = 1; i <= 5; i++) {

            if (i == 3) {
                continue;
            }

            System.out.println(i);
        }
    }

    // Program 7: Print factors
    static void printFactors() {
        System.out.println("\n=== 7. Factors ===");

        int n = 12;

        for (int i = 1; i <= n; i++) {

            if (n % i == 0) {
                System.out.println(i);
            }
        }
    }

    // Program 8: GCD using Euclidean Algorithm
    static void gcdExample() {
        System.out.println("\n=== 8. GCD ===");

        int a = 48;
        int b = 18;

        int x = a;
        int y = b;

        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }

        System.out.println("GCD = " + x);
    }

    // Program 9: LCM using GCD
    static void lcmExample() {
        System.out.println("\n=== 9. LCM ===");

        int a = 12;
        int b = 18;

        int x = a;
        int y = b;

        // First find GCD.
        while (y != 0) {
            int remainder = x % y;
            x = y;
            y = remainder;
        }

        int gcd = x;

        // Divide first to reduce overflow risk.
        long lcm = Math.abs((long) a / gcd * b);

        System.out.println("GCD = " + gcd);
        System.out.println("LCM = " + lcm);
    }

    // Program 10: Nested loop / star pattern
    static void starPattern() {
        System.out.println("\n=== 10. Star Pattern ===");

        for (int i = 1; i <= 5; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

            System.out.println();
        }
    }
}
