package String.BasicAndEasy;

import java.util.Arrays;

public class LeftMostNonRepeatingCharacter {

	public static void main(String[] args) {

		String s = "aabcddefbz";

		System.out.println(findLeftMostNonReptNaiveSol(s, s.length()));

		System.out.println(leftRepeatingBetterSol(s, s.length()));

		System.out.println(leftRepeatingEfficientSolOne(s, s.length()));
	}

	private static int findLeftMostNonReptNaiveSol(String s, int n) {

		for (int i = 0; i < n; i++) {

			boolean flag = false;
			for (int j = 0; j < n; j++) {

				if (i != j && s.charAt(i) == s.charAt(j)) {
					flag = true;
					break;
				}
			}

			if (flag == false)
				return i;
		}
		return -1;
	}

	private static int leftRepeatingBetterSol(String s, int n) {

		int count[] = new int[26];

		for (int i = 0; i < n; i++) {
			count[s.charAt(i) - 'a']++;
		}

		for (int j = 0; j < n; j++) {
			if (count[s.charAt(j) - 'a'] == 1) {
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

			if (index[s.charAt(i) - 'a'] == -1) {

				index[s.charAt(i) - 'a'] = i;
			} else {

				index[s.charAt(i) - 'a'] = -2;
			}
		}

		for (int j = 0; j < n; j++) {
			if (index[j] > 0) {
				res = Math.min(res, index[j]);
			}
		}

		return res == Integer.MAX_VALUE ? -1 : res;
	}

}
