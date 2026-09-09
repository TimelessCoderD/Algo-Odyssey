public class SearchArray {
    static boolean search(int[] arr, int idx, int target){
        if(idx == arr.length)
            return false;
        if (arr[idx] == target) 
             return true;
        return search (arr, idx+1, target);
    }
    public static void main(String[] args){
        int[] arr = {10,20,30,40,50,29};
        System.out.println(search(arr,0,30));
    }
}
