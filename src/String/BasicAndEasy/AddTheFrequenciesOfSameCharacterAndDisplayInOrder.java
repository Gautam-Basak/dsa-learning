package String.BasicAndEasy;

import java.util.HashMap;
import java.util.Map;

public class AddTheFrequenciesOfSameCharacterAndDisplayInOrder {

	public static void main(String[] args) {

		// Example
		// I/P - a21c10d5b7a5
		// O/P - a26b7c10d5

		String s = "a21c10d5b7a5";

		System.out.println(result(s, s.length()));

	}

	private static StringBuilder result(String s, int n) {

		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				char ch = c;
				int count = 0;

				while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {

					count = count * 10 + s.charAt(i + 1) - '0';
					i++;
				}

				map.put(ch, map.getOrDefault(ch, 0) + count);
			}
		}

		for (Map.Entry<Character, Integer> ans : map.entrySet()) {
			sb.append(ans.getKey()).append(ans.getValue());
		}

		return sb;
	}

}
