package BinarySearch.OneDArrays;

public class BinarySearch {

	public static void main(String[] args) {

		int a[] = { 2, 5, 3, 9, 10, 14, 16, 18, 20, 22, 24 };
		int target = 2;
		// Let think that we don't know whether the given array in sorted asc or des

		System.out.println(binarySearch(a, target));
	}

	private static int binarySearch(int[] a, int target) {
		
		int start = 0;
		int end = a.length - 1;

		boolean isAsc = a[start] < a[end];

		while (start <= end) {
			int mid = (start + end) / 2;

			if (target == a[mid]) {
				return mid;
			}
			if (isAsc) {
				if (target < a[mid]) {
					end = mid - 1;
				} else if (target > a[mid])
					start = mid + 1;
			} else {
				if (target < a[mid]) {
					start = mid + 1;
				} else if (target > a[mid])
					end = mid - 1;
			}

		}
		return -1;
	}

}
