public class CheckPalendram {
    static boolean checkPallendram(String str,int ldx,int rdx){
        
        if(ldx >= rdx)
            return true;
        if(str.charAt(rdx) != str.charAt(ldx))
            return false;
        return checkPallendram(str,ldx+1,rdx-1);
    }
	public static void main(String[] args) {
		
		String str = "Debashis Pati";
        System.out.println(checkPallendram(str,0,str.length() -1 ));

	}
}
