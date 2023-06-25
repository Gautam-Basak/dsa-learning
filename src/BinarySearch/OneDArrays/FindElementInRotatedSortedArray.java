package BinarySearch.OneDArrays;

public class FindElementInRotatedSortedArray {
	
	//Here the target element will be found not based on pivot
	//Rotated mean, it must be rotated.
	//You cannot say 1, 2, 3, 4, 5 or 5, 4, 3, 2, 1 is a zero rotated array.
	//They are increasing or decreasing sorted array.

	public static void main(String[] args) {

		int a[] = { 5, 4, 3, 2, 1 };
		int target = 2;

		System.out.println(findElementInRotatedSortedArray(a, a.length, target));

	}

	private static int findElementInRotatedSortedArray(int[] a, int n, int target) {

		int start = 0;
		int end = n - 1;

		while (start <= end) {

			int mid = (start + end) >> 1;
			if (a[mid] == target)
				return mid;

			// The left half is sorted
			if (a[start] <= a[mid]) {
				//Figure out if element lies on the left half or not
				if (target >= a[start] && target <= a[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			// The right half is sorted
			else {
				if (target >= a[mid] && target <= a[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}

			}
		}
		return -1;

	}

}
