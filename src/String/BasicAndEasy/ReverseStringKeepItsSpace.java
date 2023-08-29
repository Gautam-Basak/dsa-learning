package String.BasicAndEasy;

public class ReverseStringKeepItsSpace {

	private static void reverseWordInSamePos(String s) {

		char[] input = s.toCharArray();
		char[] result = new char[input.length];

		int j = s.length() - 1;

		for (int i = 0; i < s.length(); i++) {

			if (input[i] == ' ') {
				result[i] = ' ';
			}
		}

		for (int i = 0; i < s.length(); i++) {

			if (input[i] != ' ') {
				if (result[j] == ' ') {
					j--;
				}
				result[j] = input[i];
				j--;
			}
		}
		System.out.println(result);
	}

	public static void main(String[] args) {

		String s = "I am a Java Developer";
		reverseWordInSamePos(s);

	}

}
