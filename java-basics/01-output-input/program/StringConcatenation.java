package program;

public class StringConcatenation {
    public static void main(String[] args) {

        String firstName = "Dev";
        String lastName = "Pati";

        // String + String
        System.out.println(firstName + " " + lastName);

        // String + Number
        System.out.println("Age: " + 35);

        // Arithmetic expression before concatenation
        System.out.println("Result: " + (5 + 3));

        // Operator precedence
        System.out.println("Result: " + 5 + 3);

        // String + String + Number
        System.out.println("Total: " + "₹" + 500);
    }
}
