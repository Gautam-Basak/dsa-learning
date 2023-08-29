package String.BasicAndEasy;

import java.util.ArrayList;

public class CountTheAdjustedSameCharaters {

	static ArrayList<String> result(String s[]) {

		ArrayList<String> list = new ArrayList<>();

		for (String inpStr : s) {

			char[] modifiedChar = new char[inpStr.length()];
			int modifiedIndex = 0;

			for (int i = 0; i < inpStr.length(); i++) {

				char currChar = inpStr.charAt(i);
				modifiedChar[modifiedIndex++] = currChar;

				while (i + 1 < inpStr.length() && inpStr.charAt(i + 1) == currChar) {
					i++;

				}

			}

			list.add(new String(modifiedChar, 0, modifiedIndex));
		}

		return list;
	}

	static ArrayList<Integer> result1(String s[], int n) {

		ArrayList<Integer> list = new ArrayList<>();

		for (String inpStr : s) {
			int count = 0;

			for (int i = 0; i < inpStr.length() - 1; i++) {
				if (inpStr.charAt(i) == inpStr.charAt(i + 1)) {
					count++;
				}
			}

			list.add(count);
		}

		return list;
	}

	public static void main(String[] args) {

		// Return the count of adjusted or removed same adjacent character keeping one
		// of the same character to get new string
		// Example
		// I/P - add
		// O/T - 1 , because two d are adjacent and we can remove one.
		// I/P - Break;
		// O/P - 0.

		String s[] = { "add", "boook", "break" };

		System.out.println(result(s));

		ArrayList<Integer> resultList = result1(s, s.length);

		System.out.println(resultList);

	}

}
