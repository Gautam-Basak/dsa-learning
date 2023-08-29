package String.BasicAndEasy;

import java.util.Arrays;

public class LeftMostRepeatingCharacter {

	private static int leftRepeatingNaiveSol(String s, int n) {

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j))
					return i;
			}
		}
		return -1;
	}

	private static int leftRepeatingBetterSol(String s, int n) {

		int count[] = new int[26];

		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
		}

		for (int j = 0; j < n; j++) {
			if (count[s.charAt(j) - 'a'] > 1) {
				return j;
			}
		}
		return -1;
	}

	private static int leftRepeatingEfficientSolOne(String s, int n) {

		int index[] = new int[26];

		Arrays.fill(index, -1);

		int res = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {

			int indx = index[s.charAt(i) - 'a'];
			if (indx == -1) {
				index[s.charAt(i) - 'a'] = i;
			} else {
				res = Math.min(res, indx);
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

	private static int leftRepeatingEfficientSolTwo(String s, int n) {

		boolean visited[] = new boolean[26];
		int res = -1;

		for (int i = n - 1; i >= 0; i--) {
			if (visited[s.charAt(i) - 'a'])
				res = i;
			else
				visited[s.charAt(i) - 'a'] = true;
		}
		return res;
	}

	public static void main(String[] args) {

		String s = "abccccccedfgi";

		// Naive Solution
		// Use two for loops, one from i=0 and other from j=i+1,check for equal.
		// If found return the index
		System.out.println(leftRepeatingNaiveSol(s, s.length()));

		// Better Approach
		// Even though the T.C is linear, the interview can ask to get the ans using one
		// loop
		System.out.println(leftRepeatingBetterSol(s, s.length()));

		// Efficient Solution One
		System.out.println(leftRepeatingEfficientSolOne(s, s.length()));

		// Efficient Solution Two
		System.out.println(leftRepeatingEfficientSolTwo(s, s.length()));
	}

}
