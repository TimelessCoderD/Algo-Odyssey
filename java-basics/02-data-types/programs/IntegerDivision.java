public class IntegerDivision {

    public static void main(String[] args) {

        int a = 5;
        int b = 2;

        // Integer division
        int result = a / b;

        System.out.println("5 / 2 = " + result);

        // Decimal division
        double decimalResult = (double) a / b;

        System.out.println("5 / 2 = " + decimalResult);

        // Remainder using modulus
        int remainder = a % b;

        System.out.println("5 % 2 = " + remainder);
    }
}