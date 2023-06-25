package String.BasicAndEasy;

public class Palindrome {

	private static boolean palindrome(String s) {

		if (s == null || s.length() == 0)
			return false;

		int start = 0;
		int end = s.length() - 1;

		while (start <= end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			else {
				start++;
				end--;
			}
		}
		return true;
	}

	public static void main(String[] args) {

		String s = null;

		if (palindrome(s)) {
			System.out.println("Given String is Palindrome");
		} else {
			System.out.println("Given String is not Valid/Palindrome");
		}
	}
}
