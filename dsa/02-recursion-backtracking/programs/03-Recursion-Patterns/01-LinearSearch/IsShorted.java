public class IsShorted {
    static boolean isSorted(int[] arr, int idx) {

        if (idx == arr.length - 1 )
            return true;

        if (arr[idx] <= arr[idx + 1])
            return isSorted(arr, idx + 1);
        else
            return false;
    }
    public static void main(){
        int arr[] = {10,20,30,40,40};
        System.out.println(isSorted(arr,0));
    }
}
