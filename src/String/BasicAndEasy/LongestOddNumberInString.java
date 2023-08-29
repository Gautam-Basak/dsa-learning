package String.BasicAndEasy;

public class LongestOddNumberInString {

	

	public static void main(String[] args) {

		String s = "501";
		System.out.println(longestOddNumber(s, s.length()));
		
	}

	private static String longestOddNumber(String s, int n) {
		
		String res = "";
		for(int i=n-1; i>=0; i--) {
			
			//Check whether the last character is odd or not
			if(s.charAt(i)%2 != 0) {
				
				//If the last character is odd, then entire String is odd.
				res = s.substring(0, i+1);
				return res;
			}
		}
		
		return res;
	}
}
