public class FindMinMax {
    int min, max;

    FindMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    static FindMinMax minMax(int[] arr, int ldx, int rdx) {
        if ( ldx == rdx) {
            return new FindMinMax(arr[ldx],arr[rdx]);
        }
        int mid = (ldx + rdx) / 2;
        FindMinMax left = minMax(arr,ldx,mid);
        FindMinMax right = minMax(arr,mid+1,rdx);

        return new FindMinMax(Math.min(left.min, right.min),Math.max(left.max, right.max));
    }

    public static void main(String[] args) {
        int[] arr = {100, 2, 10, 4, 501, 601};
        FindMinMax result = minMax(arr,0,arr.length - 1);
        System.out.println("Max Val " + result.max + " && Min Val " + result.min);
    }
}
