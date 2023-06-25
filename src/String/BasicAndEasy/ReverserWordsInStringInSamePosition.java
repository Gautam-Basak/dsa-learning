package String.BasicAndEasy;

public class ReverserWordsInStringInSamePosition {

	private static void reverse(char[] ch, int start, int end) {

		char temp = ch[start];
		ch[start] = ch[end];
		ch[end] = temp;

		start++;
		end--;

	}

	private static void reverseWordInSamePos(char[] ch, int n) {

		int start = 0;
		for (int end = 0; end < n; end++) {

			if (ch[end] == ' ') {

				reverse(ch, start, end - 1);
				start = end + 1;
			}
		}

		reverse(ch, start, n - 1);

	}

	public static void main(String[] args) {

		String s = "Ram is Good Boy";
		char[] ch = s.toCharArray();

		reverseWordInSamePos(ch, ch.length);
		System.out.println(ch);
	}

}
