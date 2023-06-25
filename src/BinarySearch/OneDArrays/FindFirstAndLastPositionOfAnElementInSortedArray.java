package BinarySearch.OneDArrays;

import java.util.Arrays;

public class FindFirstAndLastPositionOfAnElementInSortedArray {

	public static void findFirstAndLastUsingLinearSearch(int arr[], int x) {
		int n = arr.length;
		int first = -1, last = -1;
		for (int i = 0; i < n; i++) {
			if (x != arr[i])
				continue;
			if (first == -1)
				first = i;
			last = i;
		}
		if (first != -1) {
			System.out.println("First Occurrence = " + first);
			System.out.println("Last Occurrence = " + last);
		} else
			System.out.println("Not Found");
	}

	private static int[] searchFirstAndLastUsingBinarySearch(int[] arr, int x) {

		int ans[] = { -1, -1 };
		int start = search(arr, x, true);
		int end = search(arr, x, false);

		ans[0] = start;
		ans[1] = end;
		return ans;
	}

	private static int search(int[] arr, int target, boolean firstStartIndex) {

		int ans = -1;
		int start = 0;
		int end = arr.length - 1;
		while (start <= end) {

			int mid = start + (end - start) / 2;

			if (target < arr[mid]) {
				end = mid - 1;
			} else if (target > arr[mid]) {
				start = mid + 1;
			} else {
				ans = mid;
				if (firstStartIndex) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 2, 2, 2, 3 };
		int x = 2;
		//Linear Search
		// T.C = O(n)
		findFirstAndLastUsingLinearSearch(arr, x);
		
		//Binary Search
		//T.C = O(Log n)
		int ans[] = searchFirstAndLastUsingBinarySearch(arr, x);
		System.out.println(Arrays.toString(ans));
	}

}
