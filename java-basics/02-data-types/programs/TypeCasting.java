public class TypeCasting {

    public static void main(String[] args) {

        // Widening conversion (automatic)
        int a = 100;
        long b = a;

        System.out.println("Widening conversion:");
        System.out.println("int value: " + a);
        System.out.println("long value: " + b);

        // Narrowing conversion (explicit)
        long c = 1000L;
        int d = (int) c;

        System.out.println("\nNarrowing conversion:");
        System.out.println("long value: " + c);
        System.out.println("int value: " + d);

        // Narrowing can cause data loss
        long largeValue = 10000000000L;
        int convertedValue = (int) largeValue;

        System.out.println("\nNarrowing with data loss:");
        System.out.println("Original long value: " + largeValue);
        System.out.println("Converted int value: " + convertedValue);
    }
}