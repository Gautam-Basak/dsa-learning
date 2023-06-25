package BinarySearch.OneDArrays;

public class PositionOfAnElementInInfiniteLenghtArray {

	public static void main(String[] args) {

		// Same as binary search just length is not given

		// Just consider taking chunks of element at a time and increase the length if
		// not found.
		// In that way it will be considered as infinite size array. Don't the
		// arr.lenght anywhere.

		int a[] = { 2, 5, 7, 9, 10, 14, 16, 18, 20, 22, 24, 25, 27, 30 };
		int target = 16;

		int start = 0;
		int end = 1;

		while (target > a[end]) {
			int newStart = end + 1;
			end = end + (end - start + 1) * 2;
			start = newStart;

		}

		System.out.println(binarySearch(a, target, start, end));
	}

	private static int binarySearch(int[] a, int target, int start, int end) {

		while (start <= end) {
			int mid = (start + end) / 2;

			if (target < a[mid]) {
				end = mid - 1;
			} else if (target > a[mid]) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;

	}

}
