package String.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class CountSubStringsWithExactlyKDistinctCharacters {

	private static int subStringsWithKDistinctCharacters(String s, int n, int k) {

		int seen[] = new int[26];

		int result = 0;

		for (int i = 0; i < n; i++) {

			int distinctCount = 0;
			Arrays.fill(seen, -1);

			for (int j = i; j < n; j++) {

				if (seen[s.charAt(j) - 'a'] == -1) {
					distinctCount++;
				}
				seen[s.charAt(i) - 'a'] = 1;

				if (distinctCount == k)
					result++;
			}

		}
		return result;
	}

	public static void main(String[] args) {

		String s = "abc";
		int k = 3;

		// Brute Force
		System.out.println(subStringsWithKDistinctCharacters(s, s.length(), k));

		// SlidingWindow
		System.out.println(subStringsWithKDistinctCharactersEfficientSol(s, s.length(), k));
	}

	private static int subStringsWithKDistinctCharactersEfficientSol(String s, int n, int k) {

		return extract_K_Chars_SubStrings(s, n, k) - extract_K_Chars_SubStrings(s, n, k - 1);
	}

	private static int extract_K_Chars_SubStrings(String s, int n, int k) {

		if (s.length() == 0) {
			return 0;
		}

		HashMap<Character, Integer> map = new HashMap<>();

		int num = 0;
		int left = 0;

		for (int i = 0; i < n; i++) {

			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

			while (map.size() > k) {
				map.put(s.charAt(left), map.getOrDefault(s.charAt(left), 0) - 1);

				if (map.get(s.charAt(left)) == 0) {
					map.remove(s.charAt(i));
				}
				left++;
			}
			num = num + i - left + 1;
		}

		return num;
	}

}
