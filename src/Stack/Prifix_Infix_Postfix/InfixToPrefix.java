package Stack.Prifix_Infix_Postfix;

import java.util.Stack;

public class InfixToPrefix {

	static int precedence(char ch) {

		switch (ch) {

		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;

		}
		return -1;
	}

	private static String infixToPostfix(String exp) {

		Stack<Character> s = new Stack<>();
		String prefix = "";
		String result = "";

		for (int i = exp.length() - 1; i >= 0; i--) {

			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c))
				prefix = prefix + c;

			else if (c == ')')
				s.push(c);

			else if (c == '(') {

				while (!s.isEmpty() && s.peek() != ')') {

					prefix += s.pop();
				}
				// Remove the first ')'
				s.pop();
			} else {

				while (!s.isEmpty() && precedence(c) <= precedence(s.peek())) {

					prefix += s.pop();
				}
				s.push(c);
			}

		}
		while (!s.isEmpty()) {
			if (s.peek() == ')')
				return "Invalid Expression";
			else
				prefix += s.pop();
		}

		result = reverse(prefix);
		return result;
	}

	private static String reverse(String prefix) {

		String output = "";
		for (int i = 0; i < prefix.length(); i++) {

			output = prefix.charAt(i) + output;
		}
		return output;
	}

	public static void main(String[] args) {

		// Same as InfixToPostfix, only changes is reverse the result and begin with ")"

		String exp = "((p+q)*(m-n))";

		System.out.println("Infix expression: " + exp);
		System.out.println("Prefix expression: " + infixToPostfix(exp));

	}
}
