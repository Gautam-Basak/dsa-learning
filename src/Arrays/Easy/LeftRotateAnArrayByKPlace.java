package Arrays.Easy;

import java.util.Arrays;

public class LeftRotateAnArrayByKPlace {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 3;

		/**
		 * 1. Brute Force 
		 * TC = O(d)+O(n-d)+O(d) = O(n+d) 
		 * SC = O(d) extra space as we are using a temporary array of size d
		 * 
		 * leftRotateKPlaceBrute(arr, d, arr.length);
		 * System.out.println(Arrays.toString(arr));
		 **/
		
		// 2. Optimal Solution
		// TC = O(d)+O(n-d)+O(n) = O(2*n), where n = size of the array, d = the number of rotations.
		// Each term corresponds to each reversal step.
		// SC = O(1) since no extra space is required.
		leftRotateKPlaceOptimal(arr, d, arr.length);
		System.out.println(Arrays.toString(arr));
	}

	// Brute Force
	private static void leftRotateKPlaceBrute(int[] arr, int d, int n) {
		
		//Check if size of array is zero
		if (n == 0) return;
		
        // Get the effective number of rotations:
        d = d % n;

        // checking if d is a multiple of n:
        if (d == 0) return;

		int temp[] = new int[d];
		for (int i = 0; i < d; i++) {
			temp[i] = arr[i];
		}
		for (int i = d; i < n; i++) {
			arr[i - d] = arr[i];
		}
		for (int i = n - d; i < n; i++) {
			arr[i] = temp[i - (n - d)];
		}
	}
	
	//Optimal Solution
	private static void leftRotateKPlaceOptimal(int[] arr, int d, int n) {
		
		//Check if size of array is zero
		if (n == 0) return;
		
		// Get the effective number of rotations:
		d = d % n;

		// checking if d is a multiple of n:
		if (d == 0) return;

		reverse(arr, 0, d - 1);

		reverse(arr, d, n - 1);

		reverse(arr, 0, n - 1);
	}

	private static void reverse(int[] arr, int low, int high) {

		while (low <= high) {
			int temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;

			low++;
			high--;
		}

	}

}
