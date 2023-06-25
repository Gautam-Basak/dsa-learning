package String.BasicAndEasy;

import java.util.HashMap;

public class IsomorphicStrings {

	public static void main(String[] args) {

		String str1 = "abc";
		String str2 = "pqr";

		// Function Call
		if (str1.length() == str2.length() && areIsomorphic(str1, str2))
			System.out.println("True");
		else
			System.out.println("False");

	}

	private static boolean areIsomorphic(String str1, String str2) {

		HashMap<Character, Character> map = new HashMap<>();

		for (int i = 0; i < str1.length(); i++) {

			if (map.containsKey(str1.charAt(i))) {
				char c = map.get(str1.charAt(i));
				if (c != str2.charAt(i))
					return false;

			} else if (!map.containsValue(str2.charAt(i))) {
				map.put(str1.charAt(i), str2.charAt(i));
			} else
				return false;
		}

		return true;
	}

}
