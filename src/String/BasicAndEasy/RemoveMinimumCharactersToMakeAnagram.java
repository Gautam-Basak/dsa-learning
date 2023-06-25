package String.BasicAndEasy;

public class RemoveMinimumCharactersToMakeAnagram {

	private static int removeCharacterToMakeAnagram(String s1, String s2) {

		int count1[] = new int[26];
		int count2[] = new int[26];
		int result = 0;

		for (int i = 0; i < s1.length(); i++) {
			count1[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			count2[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			result = result + Math.abs(count1[i] - count2[i]);
		}
		return result;
	}

	public static void main(String[] args) {

		String s1 = "aaa";
		String s2 = "a";

		System.out.println(removeCharacterToMakeAnagram(s1, s2));

	}

}
