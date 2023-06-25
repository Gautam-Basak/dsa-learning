package String.BasicAndEasy;

public class ReverseWordsInString {

	private static void reverse(char[] s, int start, int end) {

		while (start <= end) {

			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			start++;
			end--;
		}

	}

	private static void reverseWords(char[] s, int n) {

		int start = 0;
		for (int end = 0; end < n; end++) {
			if (s[end] == ' ') {

				// Once we find a space, means we found a word, reverse it.
				reverse(s, start, end - 1);
				start = end + 1;
			}
		}
		// For the last word we don't encounter any space, so we separately reverse it.
		reverse(s, start, n - 1);

		reverse(s, 0, n - 1);
	}

	public static void main(String[] args) {

		String str = "I am a Java Developer";
		char[] s = str.toCharArray();
		
		System.out.println("Before reversing words in the string:");
		System.out.println(str);
		
		

		System.out.println("\nAfter reversing words in the string:");
		reverseWords(s, s.length);
		System.out.println(s);

	}

}
