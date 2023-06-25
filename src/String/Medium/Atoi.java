package String.Medium;

public class Atoi {
	static int atoi(String s, int n) {
		
		 int i=0;
		 int sign = 1;
		 int result = 0;
		 
		 while(i<n && s.charAt(i)==' ') {
			 i++;
		 }
		 if(i<n && s.charAt(i)=='-') {
			 sign = -1;
		 }
		 for(; i<n; i++) {
			 if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9) {
			 result = result*10 + s.charAt(i)-'0';
			 }
		 }
		 return sign*result;
	 }

	public static void main(String[] args) {

		String s = "-     a234";
		System.out.println(atoi(s, s.length()));

	}

}
