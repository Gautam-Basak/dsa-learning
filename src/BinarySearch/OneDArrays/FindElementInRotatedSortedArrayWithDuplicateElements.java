package BinarySearch.OneDArrays;

public class FindElementInRotatedSortedArrayWithDuplicateElements {

	public static void main(String[] args) {

		int a[] = { 3, 3, 1, 3, 3, 3 };
		int target = 3;

		System.out.println(findTargetIfContainDuplicates(a, target, a.length));

	}

	private static int findTargetIfContainDuplicates(int[] a, int target, int n) {

		int start = 0;
		int end = n - 1;

		while (start <= end) {

			int mid = (start + end) >> 1;

			if (a[mid] == target)
				return mid;

			if (a[start] == a[mid] && a[mid] == a[end]) {
				start++;
				end--;
			}
			if (a[start] <= a[mid]) {
				if (target >= a[start] && target <= a[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
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
