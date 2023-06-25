package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Divide the array hypothetically into two part and repeat the process until
// you get single element
// and then merge
public class MergeSorting {

	private static void mergeSort(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;

		mergeSort(arr, low, mid);

		mergeSort(arr, mid + 1, high);

		mergre(arr, low, mid, high);

	}

	private static void mergre(int[] arr, int low, int mid, int high) {

		List<Integer> temp = new ArrayList<>();
		int left = low;
		int right = mid + 1;

		while (left <= mid && right <= high) {
			if (arr[left] < arr[right]) {
				temp.add(arr[left]);
				left++;
			} else {
				temp.add(arr[right]);
				right++;
			}
		}

		while (left <= mid) {
			temp.add(arr[left]);
			left++;
		}

		while (right <= high) {
			temp.add(arr[right]);
			right++;
		}

		for (int i = low; i <= high; i++) {
			arr[i] = temp.get(i - low);
		}

	}

	public static void main(String[] args) {

		int arr[] = { 4, 2, 5, 1, 8, 2, 5, 1 };
		int n = arr.length;
		mergeSort(arr, 0, n - 1);

		System.out.println(Arrays.toString(arr));
	}

}
