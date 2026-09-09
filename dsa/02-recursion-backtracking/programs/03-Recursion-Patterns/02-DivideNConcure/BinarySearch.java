
public class BinarySearch {
        static int binarySearch(int[] arr, int ldx, int rdx, int target) {

        if (ldx > rdx)
            return -1;

        int tempPosition = (ldx + rdx) / 2;

        if (arr[tempPosition] == target)
            return tempPosition;

        if (arr[tempPosition] > target)
            return binarySearch(arr, ldx, tempPosition - 1, target);
        else
            return binarySearch(arr, tempPosition + 1, rdx, target);
    }
	public static void main(String[] args) {
		
		int[] arr = {10,20,30,40,50,60,70,80,90};
        System.out.println(binarySearch(arr,0,arr.length - 1,100 ));

	}
}
