package Recursion.GetStrongHold;

public class RecursiveImplementationOfAtoi {

	public static void main(String[] args) {

		String str = "";
		int n = str.length();

		System.out.println(myAtoiRecursive(str, n));

	}

	private static int myAtoiRecursive(String str, int n) {

		if (str == "" || !str.matches("^\\d*$")) {
			return 0;
		}

		if (n == 1)
			return str.charAt(0) - '0';

		return (10 * myAtoiRecursive(str, n - 1) + str.charAt(n - 1) - '0');

	}

}
