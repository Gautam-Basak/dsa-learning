package Sorting;

import java.util.Arrays;

public class InsertionSorting {

	// Select an element and place it in its correct order
	public static void main(String[] args) {

		int arr[] = { 1, 5, 8, 2, 3, 15, 9 };
		insertSort(arr, arr.length);
		System.out.println(Arrays.toString(arr));

	}

	private static void insertSort(int[] arr, int n) {

		for (int i = 0; i < n - 1; i++) {

			int j = i;
			while (j > 0 && arr[j - 1] > arr[j]) {

				int temp = arr[j - 1];
				arr[j - 1] = arr[j];
				arr[j] = temp;
				j--;

			}
		}
	}
}
