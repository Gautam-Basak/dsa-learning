package Arrays.Hard;

public class FindRepeatingAndMissingElement {

	public static void main(String[] args) {

		int a[] = { 3, 1, 2, 5, 4, 6, 7, 5 };

		// 1. Brute Force
		// We will use two loops, 1st will go from 1 to n and 2nd will go from 0 to n-1,
		// and will check
		// in the second loop whether a[j] == i and will count the occurrence, when the
		// count is 2
		// that will be our repeating element and when the count is zero that will be
		// our missing element.

		// 1. Better Solution
		// We will use one loop and hashing, the loop will run from 0 to n-1 and
		// accordingly hash it hash[a[i]++].
		// Next we will run a separate loop from 1 to n, and check if the hash
		// occurrence 2 that will be our
		// repeating element and when the hash occurrence is zero that will be our
		// missing element.

		// 3. Optimal Solution One.
		// int[] ans = repeatingAndMissingElementOptimalOne(a, a.length);
		// System.out.println("The repeating and missing numbers are: {" + ans[0] + ", "
		// + ans[1] + "}");

		// 4. Optimal Solution two.
		// Steps :-
		// a)XOR all a[i] -> x
		// b)x ^ (1 ^ 2 ^ 3 ^.....^ n)
		// c)x ^ y = num (where x is the missing and y is the repeating element)
		// d)Separate all the given array element in two buckets based on the bit that
		// is set or not in num
		// e)Again separate 1 to N number in two buckets based on the bit that is set or
		// not in num
		// f)XOR both bucket of step d and e to find the number missing and repeating
		// element.
		int[] ans = repeatingAndMissingElementOptimalTwo(a, a.length);
		System.out.println("The repeating and missing numbers are: {" + ans[0] + ", " + ans[1] + "}");

	}

	private static int[] repeatingAndMissingElementOptimalOne(int[] a, int n) {

		int Sn = (n * (n + 1)) / 2;
		int Sn2 = (n * (n + 1) * (2 * n + 1)) / 6;

		int S = 0, S2 = 0;
		for (int i = 0; i < n; i++) {

			S = S + a[i];
			S2 = S2 + (a[i] * a[i]);
		}
		// S-Sn = X-Y
		int val1 = S - Sn;
		// S2-Sn2 = X2-Y2
		int val2 = S2 - Sn2;

		// Find X+Y = (X^2-Y^2)/(X-Y):
		val2 = val2 / val1;

		int X = (val1 + val2) / 2;
		int Y = X - val1;

		int[] ans = { (int) X, (int) Y };
		return ans;

	}

	private static int[] repeatingAndMissingElementOptimalTwo(int[] a, int n) {

		int xr = 0;
		for (int i = 0; i < n; i++) {
			xr = xr ^ a[i];
			xr = xr ^ (i + 1);
		}

		int number = (xr & ~(xr - 1));

		int one = 0, zero = 0;
		for (int i = 0; i < n; i++) {
			if ((a[i] & number) != 0) {
				one = one ^ a[i];
			} else
				zero = zero ^ a[i];
		}

		for (int i = 1; i <= n; i++) {
			if ((i & number) != 0) {
				one = one ^ i;
			} else
				zero = zero ^ i;
		}
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (a[i] == zero)
				cnt++;
		}

		if (cnt == 2)
			return new int[] { zero, one };
		return new int[] { one, zero };

	}

}
