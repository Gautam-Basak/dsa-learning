package Sorting;

import java.util.Arrays;

public class BubbleSorting {
	
	//Push the maximum element to the last by adjacent swap
	public static void main(String[] args) {

		int arr[] = { 1, 5, 8, 2, 3, 15, 9 };
		bubbleSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}

	private static void bubbleSort(int[] arr, int n) {

		for (int i = n - 1; i >= 1; i--) {

			int didSwap = 0;

			for (int j = 0; j <= i - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					int temp = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = temp;
					didSwap = 1;
				}
			}
			if (didSwap == 0)
				break;
		}
	}
}
