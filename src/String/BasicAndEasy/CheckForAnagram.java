package String.BasicAndEasy;

import java.util.Arrays;

public class CheckForAnagram {

	private static void checkAnagramNaive(String s1, String s2) {

		char[] c1 = s1.toCharArray();
		Arrays.sort(c1);
		s1 = new String(c1);

		char[] c2 = s2.toCharArray();
		Arrays.sort(c2);
		s2 = new String(c2);

		if (s1.equals(s2))
			System.out.println("Anagram");
		else
			System.out.println("Not Anagram");

	}

	private static boolean checkAnagramOptimal(String s1, String s2) {
		
		//Considering all are small letters
		int freq[] = new int[26];

		if (s1.length() != s2.length())
			return false;

		for (int i = 0; i < s1.length(); i++) {
			freq[s1.charAt(i) - 'a']++;
			freq[s2.charAt(i) - 'a']--;
		}

		for (int j = 0; j < freq.length; j++) {
			if (freq[j] != 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {

		String s1 = "listen";
		String s2 = "silent";

		// Naive Solution
		// T.C = O(n*log n), for sorting for the strings.
		checkAnagramNaive(s1, s2);

		// Optimal Solution
		// Using frequency count array, iterate over s1 and s2, increase the count for
		// s1 and decrease the count s2, if the frequency array return zero means
		// Anagram.
		if (checkAnagramOptimal(s1, s2))
			System.out.println("Both Strings are Anagram");
		else
			System.out.println("Both Strings are not Anagram");

	}

}
