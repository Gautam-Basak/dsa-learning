package BinarySearch.OneDArrays;

public class CeilingOfAnArrayUsingBS {

	public static void main(String[] args) {
		// Ceiling - Smallest element greater than or equal to target.

		// T.C = O(log n)

		int a[] = { 2, 5, 7, 9 };
		int target = 6;

		System.out.println(ceilingBinarySearch(a, target));

	}

	private static int ceilingBinarySearch(int[] a, int target) {

		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			// Instead use mid = start + (end-start)/2
			// If we use start+end/2, it might through error as it might exceed int value
			int mid = (start + end) / 2;
			
			//What if the target element is greater than greatest element in the array
			if (target > a[a.length - 1])
				return -1;
			if (target < a[mid]) {
				end = mid - 1;
			} else if (target > a[mid]) {
				start = mid + 1;
			} else
				return mid;
		}

		return start;
	}

}
