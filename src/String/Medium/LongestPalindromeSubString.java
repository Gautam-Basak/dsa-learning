package String.Medium;

public class LongestPalindromeSubString {

	public static void main(String[] args) {

		String s = "aabcdcbfg";

		System.out.println(longestPalindrome(s, s.length()));

	}

	private static String longestPalindrome(String s, int n) {

		int low, high;
		int start = 0, end = 1;
		String res = "";

		for (int i = 1; i < n; i++) {

			low = i - 1;
			high = i;
			while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {

				if (high - low + 1 > end) {
					start = low;
					end = high - low + 1;
					res = s.substring(start, start + end);
				}

				low--;
				high++;

			}

			low = i - 1;
			high = i + 1;
			while (low >= 0 && high < n && s.charAt(low) == s.charAt(high)) {

				if (high - low + 1 > end) {
					start = low;
					end = high - low + 1;
					res = s.substring(start, start + end);
				}

				low--;
				high++;

			}
		}

		return res;
	}

}
