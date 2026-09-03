public class ReverseString {
    static String reverse(String text,int idx, String revString){
       if(idx == -1)
            return revString;
        revString += text.charAt(idx);
        return reverse(text,idx -1,revString);
    }
	public static void main(String[] args) {
		
		String text = "Debashis Pati";
        System.out.println(reverse(text,text.length() -1 ,""));

		
	}
}
