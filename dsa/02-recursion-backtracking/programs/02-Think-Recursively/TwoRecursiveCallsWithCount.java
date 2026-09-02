public class TwoRecursiveCallsWithCount {

    static int count = 0;

    static void fun(int n) {
        count++;

        if (n == 0)
            return;

        fun(n - 1);
        fun(n - 1);
    }

    public static void main(String[] args) {
        fun(3);

        System.out.println("Total calls: " + count);
    }
}