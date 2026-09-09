public class MaxInArray {
    //Dev Method
    static int max(int[] arr,int idx, int maxval){
        if(idx == arr.length) 
            return maxval;
        return max(arr,idx+1, Math.max(maxval,arr[idx]));

    }

    //Method by Study
    static int max2(int[] arr, int index) {

        if (index == arr.length - 1)
            return arr[index];

        return Math.max(arr[index], max2(arr, index + 1));
    }
    public static void main(String[] args){
        int[] arr = {1,2,10,4,5};
        
        
        System.out.println(max(arr,1,arr[0]));
        
        
        System.out.println(max2(arr,0));


    }
}
