package String.BasicAndEasy;

public class CheckIfaStringIsSubsequenceOfOther {

	private static boolean checkIfSubsequenceRecursive(String s1, int n, String s2, int m) {
		
		//If s2 already exhausted, means s2 is present in s1.
		if (m == 0)
			return true;
		//n==0, only give true when both n and m equals are zero 
		else if (n == 0)
			return false;

		if (s1.charAt(n - 1) == s2.charAt(m - 1))
			return checkIfSubsequenceRecursive(s1, n - 1, s2, m - 1);
		else
			return checkIfSubsequenceRecursive(s1, n - 1, s2, m);
	}

	private static boolean checkIfSubsequenceOptimal(String s1, int n, String s2, int m) {

		int j = 0;
		for (int i = 0; i < n; i++) {

			if (s1.charAt(i) == s2.charAt(j)) {
				j++;
			}
		}
		return j == m;
	}

	public static void main(String[] args) {

		String s1 = "AABCEDGFKJ";
		String s2 = "AEGJ";

		// Naive Solution
		// Find all the subsequences and verify with s2.
		// T.C = (2^n * m) - 2^n for n length string and m(for comparing s2 with all
		// subsequence)

		// Recursive Solution
		// T.C = O(n+m), S.C =O(n+m), m+n for function call stack
		if (checkIfSubsequenceRecursive(s1, s1.length(), s2, s2.length()))
			System.out.println("Sub-Subsequence");
		else
			System.out.println("Not Sub-Subsequence");

		// Optimal Solution(Iterative)
		// Use for loop, slide over two string and check, if it is same or not, if
		// same increase both the counter else increase only the String s1's counter.
		// T.C = O(n+m), S.C = O(1)

		if (checkIfSubsequenceOptimal(s1, s1.length(), s2, s2.length()))
			System.out.println("Sub-Subsequence");
		else
			System.out.println("Not Sub-Subsequence");
	}

}
