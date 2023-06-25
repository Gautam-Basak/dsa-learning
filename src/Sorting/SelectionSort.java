package Sorting;

import java.util.Arrays;


//Select smallest element and swap to the First, then select the second 
//smallest and swap it to the Second and so on. 
public class SelectionSort {

	public static void main(String[] args) {

		int arr[] = { 1, 5, 3, 8, 4, 12 };
		selectSort(arr, arr.length);
		
		System.out.println(Arrays.toString(arr));

	}

	private static void selectSort(int[] arr, int n) {

		for (int i = 0; i <= n - 2; i++) {

			int min = i;
			for (int j = i; j < n - 1; j++) {

				if (arr[j] < arr[min]) {
					min = j;
				}

			}

			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;

		}

	}

}
