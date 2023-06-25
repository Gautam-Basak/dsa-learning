package Arrays.Medium;

public class PrintSubArrayWithMaximumSum {

	public static int maxSubarraySumBrute(int[] arr, int n) {
		int maxi = Integer.MIN_VALUE; // maximum sum

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				// subarray = arr[i.....j]
				int sum = 0;

				// add all the elements of subarray:
				for (int k = i; k <= j; k++) {
					sum += arr[k];
				}

				maxi = Math.max(maxi, sum);
			}
		}

		return maxi;
	}

	public static int maxSubarraySumBetter(int[] arr, int n) {
		int maxi = Integer.MIN_VALUE; // maximum sum

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = i; j < n; j++) {
				// current subarray = arr[i.....j]

				// add the current element arr[j]
				// to the sum i.e. sum of arr[i...j-1]
				sum += arr[j];

				maxi = Math.max(maxi, sum); // getting the maximum
			}
		}

		return maxi;
	}

	private static long maxSubarraySumOptimal(int[] arr, int n) {

		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < n; i++) {

			sum = sum + arr[i];
			max = Math.max(max, sum);

			if (sum < 0)
				sum = 0;
		}
		return max;
	}

	public static void main(String[] args) {

		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int n = arr.length;

		/**
		 * Brute Force Using Three Loops long maxSum = maxSubarraySumBrute(arr, n);
		 * System.out.println("The maximum subarray sum is: " + maxSum);
		 **/

		/**
		 * Better Solution Using Two Loops long maxSum = maxSubarraySumBetter(arr, n);
		 * System.out.println("The maximum subarray sum is: " + maxSum);
		 **/

		/**
		 * Kadane's Algorithm (Find Sum using one loop and compare with maximum each
		 * time, if sum becomes negative set the sum to zero
		 */
		long maxSum = maxSubarraySumOptimal(arr, n);
		System.out.println("The maximum subarray sum is: " + maxSum);

	}

}
