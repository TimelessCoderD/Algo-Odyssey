public class LastIndex {
    static int lastIDX(int arr[],int idx,int target){
        if (idx < 0){
            return -1;
        }
        if(arr[idx] == target)
            return idx;
        return lastIDX(arr,idx-1,target);
    }
     public static void main(String[] args){
        int[] arr = {1,4,3,4,5};
        System.out.println(lastIDX(arr,arr.length - 1,4));
    }
}
