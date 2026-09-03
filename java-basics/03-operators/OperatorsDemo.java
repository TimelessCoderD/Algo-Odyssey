public class OperatorsDemo {

    public static void main(String[] args) {

        arithmeticOperators();
        unaryOperators();
        relationalOperators();
        logicalOperators();
        assignmentOperators();
        typePromotionAndCasting();
        charConversion();
        bitwiseOperators();
        shiftOperators();
        ternaryOperator();
        divisionAndZero();
    }

    // 1. Arithmetic operators
    static void arithmeticOperators() {
        System.out.println("=== Arithmetic Operators ===");

        int a = 10;
        int b = 3;

        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b)); // 3: integer division
        System.out.println("a % b = " + (a % b)); // 1
    }

    // 2. Unary operators
    static void unaryOperators() {
        System.out.println("\n=== Unary Operators ===");

        int a = 10;

        System.out.println("++a = " + (++a)); // 11
        System.out.println("a = " + a);       // 11

        System.out.println("a++ = " + (a++)); // 11
        System.out.println("a = " + a);       // 12

        System.out.println("--a = " + (--a)); // 11
        System.out.println("-a = " + (-a));   // -11
        System.out.println("!true = " + (!true));
    }

    // 3. Relational operators
    static void relationalOperators() {
        System.out.println("\n=== Relational Operators ===");

        int a = 10;
        int b = 20;

        System.out.println(a > b);
        System.out.println(a < b);
        System.out.println(a >= b);
        System.out.println(a <= b);
        System.out.println(a == b);
        System.out.println(a != b);
    }

    // 4. Logical operators
    static void logicalOperators() {
        System.out.println("\n=== Logical Operators ===");

        boolean t = true;
        boolean f = false;

        System.out.println("true && true  = " + (t && t));
        System.out.println("true && false = " + (t && f));
        System.out.println("false && true = " + (f && t));
        System.out.println("false && false = " + (f && f));

        System.out.println("true || true  = " + (t || t));
        System.out.println("true || false = " + (t || f));
        System.out.println("false || true = " + (f || t));
        System.out.println("false || false = " + (f || f));

        System.out.println("!true = " + (!t));
        System.out.println("!false = " + (!f));
    }

    // 5. Assignment operators
    static void assignmentOperators() {
        System.out.println("\n=== Assignment Operators ===");

        int a = 10;

        a += 5;
        System.out.println("a += 5 -> " + a);

        a -= 2;
        System.out.println("a -= 2 -> " + a);

        a *= 2;
        System.out.println("a *= 2 -> " + a);

        a /= 4;
        System.out.println("a /= 4 -> " + a);

        a %= 3;
        System.out.println("a %= 3 -> " + a);

        // Compound assignment allows implicit narrowing conversion.
        byte x = 10;
        x += 5;

        System.out.println("byte x after x += 5 -> " + x);
    }

    // 6. Type promotion and explicit casting
    static void typePromotionAndCasting() {
        System.out.println("\n=== Type Promotion and Casting ===");

        int i = 10;
        double d = 17.85;

        double result = i + d;
        System.out.println("int + double -> " + result);

        int x = 10;
        float f = 34.65f;

        float floatResult = x + f;
        System.out.println("int + float -> " + floatResult);

        long longValue = 60_000L;
        int intValue = (int) longValue;

        System.out.println("(int) 60000L -> " + intValue);

        // Demonstrating possible data loss.
        long largeValue = 1_000_000_000_000L;
        int lossyValue = (int) largeValue;

        System.out.println("(int) 1_000_000_000_000L -> " + lossyValue);

        // Decimal literals:
        double defaultDecimal = 10.83;
        float floatDecimal = 10.83f;

        System.out.println("double literal -> " + defaultDecimal);
        System.out.println("float literal  -> " + floatDecimal);
    }

    // 7. char conversion
    static void charConversion() {
        System.out.println("\n=== char Conversion ===");

        char ch = 'B';

        // char -> int: implicit conversion
        int asciiValue = ch;

        System.out.println("char B as int -> " + asciiValue);

        // int -> char: explicit conversion
        int number = 66;
        char convertedChar = (char) number;

        System.out.println("int 66 as char -> " + convertedChar);
    }

    // 8. Bitwise operators
    static void bitwiseOperators() {
        System.out.println("\n=== Bitwise Operators ===");

        int a = 5; // 0101
        int b = 3; // 0011

        System.out.println("a & b = " + (a & b)); // 0001 -> 1
        System.out.println("a | b = " + (a | b)); // 0111 -> 7
        System.out.println("a ^ b = " + (a ^ b)); // 0110 -> 6
        System.out.println("~a = " + (~a));
    }

    // 9. Shift operators
    static void shiftOperators() {
        System.out.println("\n=== Shift Operators ===");

        int a = 8;

        System.out.println("8 << 1 = " + (a << 1));
        System.out.println("8 >> 1 = " + (a >> 1));
        System.out.println("8 >>> 1 = " + (a >>> 1));
    }

    // 10. Ternary operator
    static void ternaryOperator() {
        System.out.println("\n=== Ternary Operator ===");

        int a = 10;
        int b = 20;

        int max = a > b ? a : b;

        System.out.println("Maximum = " + max);
    }

    // 11. Division by zero
    static void divisionAndZero() {
        System.out.println("\n=== Division by Zero ===");

        // Integer division by zero throws ArithmeticException.
        try {
            int result = 10 / 0;
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("10 / 0 -> ArithmeticException");
        }

        // Floating-point division by zero does not throw ArithmeticException.
        System.out.println("10.0 / 0.0 -> " + (10.0 / 0.0));
        System.out.println("0.0 / 0.0 -> " + (0.0 / 0.0));
    }
}
