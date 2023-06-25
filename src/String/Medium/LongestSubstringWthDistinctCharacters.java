package String.Medium;

public class LongestSubstringWthDistinctCharacters {

	public static void main(String[] args) {

		String s = "aaaaab";

		System.out.println(longestNonRepeatingSubString(s, s.length()));

	}

	private static int longestNonRepeatingSubString(String s, int n) {

		String text = "";
		int maxLenght = 0;
		if (s.isEmpty())
			return -1;

		else if (s.length() == 1)
			return 1;

		for (char c : s.toCharArray()) {
			String current = String.valueOf(c);

			if (text.contains(current)) {
				text = text.substring(text.indexOf(current) + 1);
			}
			text = text + String.valueOf(c);
			maxLenght = Math.max(maxLenght, text.length());
		}
		return maxLenght;
	}

}
