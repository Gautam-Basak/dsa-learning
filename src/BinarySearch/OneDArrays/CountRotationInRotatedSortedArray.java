package BinarySearch.OneDArrays;

public class CountRotationInRotatedSortedArray {

	public static void main(String[] args) {

		// Number of Rotation is nothing but the index of lowest element.
		// Couple of Solution.

		// 1. If you use Highest Pivot, then return the pivot + 1, which will given the
		// index of lowest element(which is nothing but the number of rotation), because

		// 2. If you use Lowest Pivot, the return the index of the same, because i.e is
		// only
		// the number of rotation.

		int a[] = { 4, 5, 6, 0, 1, 2, 3 };

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

		return end; // Or return start, anything will work
	}
}
