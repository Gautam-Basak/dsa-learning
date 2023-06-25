package BinarySearch.OneDArrays;

public class FindLowPivotInRotatedSortedArray {

	public static void main(String[] args) {
		int a[] = { 2, 3, 4, 5, 6 };

		System.out.println(findPivot(a, a.length));

	}

	private static int findPivot(int[] arr, int n) {

		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] < arr[end]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}

		return arr[end]; //Or return start, anything will work
	}
}
