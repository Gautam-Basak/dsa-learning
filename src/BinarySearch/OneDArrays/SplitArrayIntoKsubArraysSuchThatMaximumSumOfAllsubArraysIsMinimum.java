package BinarySearch.OneDArrays;

public class SplitArrayIntoKsubArraysSuchThatMaximumSumOfAllsubArraysIsMinimum {

	public static int ans = 10000000;

	public static void solve(int a[], int n, int k, int index, int sum, int maxsum) {

		if (k == 1) {
			maxsum = Math.max(maxsum, sum);
			sum = 0;
			for (int i = index; i < n; i++) {
				sum += a[i];
			}
			maxsum = Math.max(maxsum, sum);
			ans = Math.min(ans, maxsum);
			return;
		}

		sum = 0;

		for (int i = index; i < n; i++) {
			sum += a[i];
			maxsum = Math.max(sum, maxsum);
			solve(a, n, k - 1, i + 1, sum, maxsum);
		}
	}

	private static int solveUsingBinarySearch(int[] arr, int n, int k) {

		// Our range for binary search will be between start and end

		// Start will be Maximum element
		int start = 0;
		// End will sum of all the element
		int end = 0;

		for (int i = 0; i < n; i++) {

			start = Math.max(start, arr[i]);
			end += arr[i];
		}

		// Binary Search
		while (start < end) {
			int mid = (start + end) >> 1;

			int sum = 0;
			int pieces = 1;

			for (int a : arr) {

				sum += a;
				if (sum > mid) { //You cannot add more in this sub-array
					pieces++;
					sum = a;     //Create a new sub-array starting with this value of a
				}

			}

			if (pieces > k)
				start = mid + 1;
			else
				end = mid;
		}
		return end; //Start , Mid and End all three are same here.
	}

	public static void main(String[] args) {

		// Split the given array into K sub-arrays such that maximum sum of all sub
		// arrays is minimum

		int arr[] = { 7, 2, 5, 8, 10 };
		int k = 2; // K divisions
		int n = 5; // Size of Array

		// Using Recursion(T.C =
		solve(arr, n, k, 0, 0, 0);
		System.out.println(ans + "\n");

		// Using Binary Search
		System.out.println(solveUsingBinarySearch(arr, n, k));
	}

}
