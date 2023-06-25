package String.BasicAndEasy;

public class RemoveOuterMostParanthesis {

	private static String removeOuterParentheses(String s) {

		int openCount = 0;
		int closeCount = 0;
		int start = 0;
		String result = "";
		for (int i = 0; i < s.length(); i++) {

			char c = s.charAt(i);
			if (c == '(') {
				openCount++;
			} else if (c == ')') {
				closeCount++;
			}
			if (openCount == closeCount) {
				result = result + s.substring(start + 1, i);
				start = i + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {

		// T.C = O(n)
		// S.C = It uses constant space, except for the output string, which is
		// proportional to the number of valid parentheses pairs in s.

		String s1 = "(()())(())()";
		System.out.println(removeOuterParentheses(s1));

		// Example 2
		String s2 = "()()(()())(()())";
		System.out.println(removeOuterParentheses(s2));

		// Example 3
		String s3 = "((()))(())";
		System.out.println(removeOuterParentheses(s3));

	}

}
