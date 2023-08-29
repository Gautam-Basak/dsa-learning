package Sorting;

import java.util.Arrays;

//Select a pivot element (that can be any element here I am taking 0th element as pivot element.
//Place the pivot element in its correct position in the sorted array.
//Comparing to the pivot element place the smaller element on the left and larger element on the right.
public class QuickSorting {

	private static void quickSort(int[] arr, int low, int high) {

		if (low < high) {
			int pivot = findPivot(arr, low, high);

			quickSort(arr, low, pivot - 1);
			quickSort(arr, pivot + 1, high);
		}

	}

	private static int findPivot(int[] arr, int low, int high) {

		int pivot = arr[low];
		int i = low;
		int j = high;

		while (i < j) {

			while (arr[i] <= pivot && i <= high - 1) {
				i++;
			}

			while (arr[j] > pivot && i >= low + 1) {
				j--;
			}
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		int temp = arr[low];
		arr[low] = arr[j];
		arr[j] = temp;
		return j;
	}

	public static void main(String[] args) {

		int arr[] = { 4, 1, 2, 3, 5, 6 };
		int n = arr.length;
		quickSort(arr, 0, n - 1);

		System.out.println(Arrays.toString(arr));

	}

}
