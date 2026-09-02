public class DivideRecursion {

    static void fun(int n) {
        if (n <= 1)
            return;

        fun(n / 2);
        fun(n / 2);
    }

    public static void main(String[] args) {
        fun(16);
    }
}