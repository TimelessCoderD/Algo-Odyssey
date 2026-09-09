public class ArrayOccurance {
    static int isCount(int[] arr, int target, int idx){
        if (idx == arr.length)
            return 0;
        return ((arr[idx] == target) ? 1 : 0)
       + isCount(arr, target, idx + 1);
    }
    public static void main(String[] args){
        int[] arr = {1,3,3,4,5};
        System.out.println(isCount(arr,3,0));
    }
}
