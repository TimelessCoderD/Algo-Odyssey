
public class FindMax {

    //Method by Study
    static int findmax(int[] arr, int ldx, int rdx) {

        if (ldx == rdx)
            return arr[ldx];
        int mid = (ldx+rdx) / 2; 
        int leftMax = findmax(arr, ldx, mid);
        int rightMax = findmax(arr, mid + 1, rdx);
        return Math.max(leftMax, rightMax);
    }
    public static void main(String[] args){
        int[] arr = {100,2,10,4,501,601};

        System.out.println(findmax(arr,0,arr.length - 1));


    }
    
}
