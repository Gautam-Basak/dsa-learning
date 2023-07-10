package Stack.Hard_Implementation;

public class TrappingRainWater {

	// Naive Solution
	private static int trapNaiveSol(int[] arr, int n) {

		int waterTrapped = 0;

		for (int i = 0; i < n; i++) {

			int j = i;
			int leftMax = 0, rightMax = 0;

			while (j >= 0) {
				leftMax = Math.max(leftMax, arr[j]);
				j--;
			}

			j = i;
			while (j < n) {
				rightMax = Math.max(rightMax, arr[j]);
				j++;
			}

			waterTrapped += Math.min(leftMax, rightMax) - arr[i];

		}
		return waterTrapped;
	}

	// Better Solution
	private static int trapBetterSol(int[] arr, int n) {

		int prefix[] = new int[n];
		int suffix[] = new int[n];
		int waterTrapped = 0;

		prefix[0] = arr[0];
		for (int i = 1; i < n; i++) {
			prefix[i] = Math.max(prefix[i - 1], arr[i]);
		}

		suffix[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			suffix[i] = Math.max(suffix[i + 1], arr[i]);
		}

		for (int i = 0; i < n; i++) {
			waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
		}
		return waterTrapped;
	}

	public static void main(String[] args) {

		// 1. Naive Solution, T.C = O(n*n) and S.C = O(1)
		// If we observe carefully the amount the water stored at a particular index is
		// the minimum of maximum elevation to the left and right of the index minus the
		// elevation at that index.

		int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println("Water Trapped using Naive " + trapNaiveSol(arr, arr.length));

		// 2. Better Solution, T.C = O(3*N) and S.C = O(N)+O(N)
		// Take 2 array prefix and suffix array and precompute the leftMax and rightMax
		// for each index beforehand. Then use the formula min(prefix[I],
		// suffix[i])-arr[i] to compute water trapped at each index.
		// Example -> arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		// prefix[] = {0, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 3}, start from left
		// suffix[] = {3, 3, 3, 3, 3, 3, 3, 3, 2, 2, 2, 1}, start from right

		System.out.println("Water Trapped using Better " + trapBetterSol(arr, arr.length));

		// Optimal Solution, T.C = O(N) and S.C = O(1)
		// Using Two Pointers
		System.out.println("Water Trapped using Optimal " + trapOptimalSol(arr, arr.length));

	}

	private static int trapOptimalSol(int[] arr, int n) {

		int left = 0, right = n - 1;
		int res = 0;
		int maxLeft = 0, maxRight = 0;

		while (left <= right) {

			if (arr[left] <= arr[right]) {

				if (arr[left] >= maxLeft) {
					maxLeft = arr[left];
				} else {
					res += maxLeft - arr[left];
				}
				left++;
			} else {

				if (arr[right] >= maxRight) {
					maxRight = arr[right];
				} else {
					res += maxRight - arr[right];
				}
				right--;
			}

		}
		return res;
	}

}
