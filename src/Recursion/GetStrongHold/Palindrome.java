package Recursion.GetStrongHold;

public class Palindrome {

	public static void main(String[] args) {

		String s = "MADAM";

		if (usingRecursion(s, 0)) {
			System.out.println("Palindrome");
		} else {
			System.out.println("Not Palindrome");
		}
	}

	private static boolean usingRecursion(String s, int i) {

		if (i >= s.length() / 2)
			return true;
		if (s.charAt(i) != s.charAt(s.length() - i - 1))
			return false;
		return usingRecursion(s, i + 1);

	}
	
	/***Simple Way---
	 * int temp = n;
	 * int sum=0, r;
	 * while(n>0){
	 * r = n%10;
	 * sum = sum*10 + r;
	 * n = n/10;}
	 * if(temp==sum) --> Palindrome
	***/
}
