package Stack.Prifix_Infix_Postfix;

import java.util.Stack;

public class InfixToPostfix {

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
		String result = "";

		for (int i = 0; i < exp.length(); i++) {

			char c = exp.charAt(i);

			if (Character.isLetterOrDigit(c))
				result = result + c;

			else if (c == '(')
				s.push(c);

			else if (c == ')') {

				while (!s.isEmpty() && s.peek() != '(') {

					result += s.pop();
				}
				// Remove the first '('
				s.pop();
			} else {

				while (!s.isEmpty() && precedence(c) <= precedence(s.peek())) {

					result += s.pop();
				}
				s.push(c);
			}

		}
		while (!s.isEmpty()) {
			if (s.peek() == '(')
				return "Invalid Expression";
			else
				result += s.pop();
		}

		return result;
	}

	public static void main(String[] args) {

		String exp = "(p+q)*(m-n)";

		System.out.println("Infix expression: " + exp);
		System.out.println("Prefix expression: " + infixToPostfix(exp));

	}
}
