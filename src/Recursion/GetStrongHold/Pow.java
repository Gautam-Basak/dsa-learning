package Recursion.GetStrongHold;

public class Pow {

	static double pow(int x, int n) {

		double ans = 1.0;
		long nn = n;

		if (nn < 0) {

			nn = -1 * nn;
		}
		while (nn > 0) {

			if (nn % 2 == 0) {
				x = x * x;
				nn = nn / 2;
			} else {

				ans = ans * x;
				nn = nn - 1;
			}

		}

		if (n < 0) ans = (double)(1.0) / (double)(ans);
	    return ans;
	}

	public static void main(String[] args) {

		// Brute Force -> T.C = O(N), S.C = O(1)
		// Run a loop (power times) and multiple ans with x. If power is negative, do
		// the same process and at the end divide the ans by one.

		// Optimal -> T.C = O(Log N), S.C = O(1)

		int x = 2;
		int n = 3;

		System.out.println(pow(2, 3));

	}

}
