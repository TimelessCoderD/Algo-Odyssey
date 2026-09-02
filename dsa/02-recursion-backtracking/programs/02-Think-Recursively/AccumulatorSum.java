public class AccumulatorSum {

    static int sum(int i, int total, int n) {
        if (i > n)
            return total;

        return sum(i + 1, total + i, n);
    }

    public static void main(String[] args) {
        System.out.println(sum(1, 0, 10));
    }
}