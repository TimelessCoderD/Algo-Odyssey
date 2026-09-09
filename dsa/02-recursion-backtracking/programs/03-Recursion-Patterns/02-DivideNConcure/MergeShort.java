public class MergeShort {
     //Method by Study
    static void mergeShort(int[] arr, int ldx, int rdx) {
        if (ldx >= rdx)
            return;
        
        int mid = (ldx + rdx) /2;
        
        mergeShort(arr,ldx,mid);
        mergeShort(arr,mid+1,rdx);

        merge(arr, ldx, mid, rdx);
    }
    static void merge(int[] arr, int ldx, int mid, int rdx){
        int[] temp = new int[rdx - ldx + 1];
        int left = ldx;
        int right = mid + 1;
        int k = 0;
        int index = ldx;

        while(left <= mid && right <= rdx){
            if (arr[left] <= arr[right]){
                temp[k++] = arr[left++];
            } else {
                temp[k++] = arr[right++];
            }
        }
        while(k < temp.length){
            if(right <= rdx) {
                temp[k++] = arr[right++];
            } else {
                temp[k++] = arr[left++];
            }
        }
        
        for (int i = 0; i < temp.length; i++){
            arr[index++] = temp[i];

        }
    }
    public static void main(String[] args){
        int[] arr = {100,2,10,4,501,601};
        int[] arr2 = {20,30,40,2,7,10};
        
        mergeShort(arr2,0,arr2.length - 1);

        for (int value : arr2){
            System.out.println(value);
        }
        
    }
}
