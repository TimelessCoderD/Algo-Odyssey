public class TwoRecursiveCalls {

    static void fun(int n) {
        if (n == 0)
            return;

        fun(n - 1);
        fun(n - 1);
    }

    public static void main(String[] args) {
        fun(3);
    }
}