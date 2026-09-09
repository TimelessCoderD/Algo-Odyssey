public class PalendramArray {
    static boolean checkPallendram(int[] arr,int ldx,int rdx){
        
        if(ldx >= rdx)
            return true;
        if(arr[ldx] != arr[rdx])
            return false;
        return checkPallendram(arr,ldx+1,rdx-1);
    }
	public static void main(String[] args) {
		
		int[] arr = {10,20,30,20,10};
        System.out.println(checkPallendram(arr,0,arr.length - 1 ));

	}
}
