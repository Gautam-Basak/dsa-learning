package Arrays.Easy;

public class FindMissingNumberInArray {

	// Brute Force
	public static int missingNumberBruteForce(int[] a, int N) {

		// Outer loop that runs from 1 to N:
		for (int i = 1; i <= N; i++) {

			// flag variable to check
			// if an element exists
			int flag = 0;

			// Search the element using linear search:
			for (int j = 0; j < N - 1; j++) {
				if (a[j] == i) {

					// i is present in the array:
					flag = 1;
					break;
				}
			}

			// check if the element is missing
			// i.e flag == 0:

			if (flag == 0)
				return i;
		}

		// The following line will never execute.
		// It is just to avoid warnings.
		return -1;
	}

	// Better Solution Using Hash Array
	public static int missingNumberBetterSolution(int[] a, int N) {

		int hash[] = new int[N + 1];

		for (int i = 0; i < N - 1; i++) {
			hash[a[i]]++;
		}
		for (int i = 1; i <= N; i++) {

			if (hash[i] == 0) {
				return i;
			}
		}
		return -1;

	}

	// Optimal Solution One
	private static int missingNumberOptimalSolutionOne(int[] a, int N) {

		int sum = (N * (N + 1)) / 2;
		int sum1 = 0;
		for (int i = 0; i < N - 1; i++) {
			sum1 = sum1 + a[i];
		}
		return sum - sum1;
	}

	// Optimal Solution Using "XOR", it gives little more optimization from previous
	// optimal solution
	private static int missingNumberOptimalSolutionTwo(int[] a, int N) {

		int XOR1 = 0, XOR2 = 0;

		for (int i = 0; i < N - 1; i++) {

			XOR1 = XOR1 + a[i];
			XOR2 = XOR2 + (i + 1);
		}
		XOR2 = XOR2 ^ N;
		return (XOR1 ^ XOR2);
	}

	public static void main(String args[]) {
		int N = 5;
		int a[] = { 1, 2, 4, 5 };

		/**
		 * int ans = missingNumberBruteForce(a, N); System.out.println("The missing
		 * number is: " + ans);
		 **/

		/**
		 * 
		 * int ans = missingNumberBetterSolution(a, N); System.out.println("The missing
		 * number is: " + ans);
		 **/

		/**
		 * int ans = missingNumberOptimalSolutionOne(a, N); System.out.println("The
		 * missing number is: " + ans);
		 **/

		int ans = missingNumberOptimalSolutionTwo(a, N);
		System.out.println("The missing number is: " + ans);
	}

}
