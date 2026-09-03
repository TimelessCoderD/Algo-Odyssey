public class FindIndex {
    static int isPosition(int[] arr,int idx, int target){
        if(idx == arr.length)
            return -1;
       
        if(arr[idx] == target)
            return idx;

        return isPosition(arr,idx+1,target);
        
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        System.out.println(isPosition(arr,0,6));
    }
}
