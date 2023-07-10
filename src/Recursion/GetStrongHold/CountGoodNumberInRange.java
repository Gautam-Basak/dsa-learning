package Recursion.GetStrongHold;

public class CountGoodNumberInRange {

	public static void main(String[] args) {

		int L = 410, R = 520, d = 3;

		// T.C = O(L-R)*O(log n), S.C = O(1)
		printGoodNumber(L, R, d);

	}

	private static void printGoodNumber(int L, int R, int d) {

		for (int i = L; i <= R; i++) {
			// If current numbers is good, print it
			if (isValid(i, d))
				System.out.print(i + " ");
		}
	}

	private static boolean isValid(int n, int d) {

		int digit = n % 10;
		int sum = digit;

		if (digit == d)
			return false;

		n = n / 10;
		while (n > 0) {

			digit = n % 10;
			if (digit == d || digit <= sum)
				return false;
			else {
				sum = sum + digit;
				n = n / 10;
			}
		}
		return true;
	}

}
