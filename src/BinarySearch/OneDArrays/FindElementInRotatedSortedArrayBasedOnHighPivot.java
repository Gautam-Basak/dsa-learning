package BinarySearch.OneDArrays;

public class FindElementInRotatedSortedArrayBasedOnHighPivot {

	private static int findPivot(int[] a, int n) {

		int start = 0;
		int end = n - 1;

		while (start <= end) {
			int mid = (start + end) >> 1;

			if (mid < end && a[mid] > a[mid + 1])
				return mid;
			else if (mid > start && a[mid] < a[mid - 1])
				return mid - 1;
			else if (a[start] >= a[mid])
				end = mid - 1;
			else
				start = mid + 1;

		}
		return -1; // If nothing found.

	}

	private static int binarySearch(int[] a, int target, int start, int end) {

		while (start <= end) {
			int mid = (start + end) / 2;

			if (target < a[mid])
				end = mid - 1;
			else if (target > a[mid])
				start = mid + 1;
			else
				return mid;

		}
		return -1;
	}

	public static void main(String[] args) {

		// Here Pivot they are finding which is bigger value and as per that one, target
		// element is suppose to be found.
		

		// As it is mentioned Rotated Sorted Array, 1st we will find Pivot and then
		// based
		// on the three conditions we will find the element.
		// 1. If Pivot == Element, return pivot.
		// 2. If, Element is greater than start, then search between start and pivot - 1
		// 3. If, Element is smaller than start, then search between pivot + 1 and end

		int a[] = { 5, 6, 7, 1, 2, 3, 4 };
		int target = 7;

		int pivot = (findPivot(a, a.length));

		if (pivot == -1)
			System.out.println(binarySearch(a, target, 0, a.length - 1));

		if (target == a[pivot])
			System.out.println(pivot);

		else if (target >= a[0])
			System.out.println(binarySearch(a, target, 0, pivot - 1));

		else
			System.out.println(binarySearch(a, target, pivot + 1, a.length - 1));

	}
}
