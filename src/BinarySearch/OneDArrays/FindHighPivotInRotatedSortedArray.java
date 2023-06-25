package BinarySearch.OneDArrays;

public class FindHighPivotInRotatedSortedArray {

	public static void main(String[] args) {

		// Here 4 conditions will be checked.
		// 1. When mid is > than mid + 1, then ans is mid
		// 2. When mid is < than mid - 1, then ans is mid - 1
		// 3. When start is Greater that mid (consider all elements between start and
		// end = mid-1)
		// because after mid all element are smaller
		// 4. When start is Lesser than mid (consider all elements between start=mid+1
		// to end
		// because from mid to start all element are smaller.

		// Rotated sorted array
		int a[] = { 5, 6, 2, 3, 4 };

		System.out.println(findPivot(a, a.length));

	}

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
}