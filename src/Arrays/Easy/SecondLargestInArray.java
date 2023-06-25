package Arrays.Easy;

public class SecondLargestInArray {

	// Better Solution
	private static int findSecondLargestBetterApproach(int[] arr) {

		int largest = arr[0];
		int sLargest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest)
				largest = arr[i];
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > sLargest && arr[i] != largest)
				sLargest = arr[i];
		}

		return sLargest;
	}

	// Optimal Solution
	private static int findSecondLargestOptimalApproach(int[] arr) {

		int largest = arr[0];
		int sLargest = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > largest) {
				sLargest = largest;
				largest = arr[i];
			} else if (arr[i] > sLargest && arr[i] < largest)
				sLargest = arr[i];
		}

		return sLargest;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 7, 9, 4, 6, 3, 1 };

		// 1. Brute Force = Sort the Array First then get the element at (n-2) index for
		// Second Largest ELement
		// -- TC = O(NLog(N))

		// 2. Better Solution
		// -- TC = O(N) + O(N) = O(2N)
		System.out.println(findSecondLargestBetterApproach(arr));

		// 3. Optimal Solution
		// -- TC = O(N)
		System.out.println(findSecondLargestOptimalApproach(arr));

	}

}
