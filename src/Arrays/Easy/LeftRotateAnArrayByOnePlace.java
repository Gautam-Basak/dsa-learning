package Arrays.Easy;

import java.util.Arrays;

public class LeftRotateAnArrayByOnePlace {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		
		// 1. Brute Force
		// TC = O(N)
		// SC = O(N)
		//leftRotateArrayOnePlace(arr, arr.length);
		
		// 2. Optimal
		// TC = O(N)
		// SC = O(1)
		leftRotateArrayOnePlaceOptimal(arr);
		System.out.println(Arrays.toString(arr));

	}
	
	//Brute Force Solution
	private static void leftRotateArrayOnePlace(int[] arr, int n) {
		
		int temp[] = new int [n];
		
		for(int i=1; i<n; i++) {
			temp[i-1] = arr[i];
		}
		temp[n-1] = arr[0];
		for (int i = 0; i < n; i++) {
		    System.out.print(temp[i]+" ");
		  }
		
	}
	
	//Optimal Solution
	private static void leftRotateArrayOnePlaceOptimal(int[] arr) {

		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i - 1] = arr[i];
		}
		arr[arr.length - 1] = temp;

	}

}
