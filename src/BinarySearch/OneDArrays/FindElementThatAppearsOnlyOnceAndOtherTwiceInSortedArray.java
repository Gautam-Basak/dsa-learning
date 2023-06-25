package BinarySearch.OneDArrays;

public class FindElementThatAppearsOnlyOnceAndOtherTwiceInSortedArray {

	public static void main(String[] args) {

		// Concept:-
		// 1) If mid index is even, that means before mid even number of elements are
		// present, and if mid element and mid + 1 element are same, the desired
		// element(i.e single occurrence element) will be always on the right side.

		// 2)Similarly, if mid index is odd, that means before mid odd number of
		// elements are
		// present, and if mid element and mid - 1 element are same, the desired
		// element(i.e single occurrence element) will be always on the right side

		int a[] = { 1, 1, 2, 2, 3, 4, 4, 5, 5, };

		System.out.println(searchForOneOccurrenceElement(a, a.length));

	}

	private static int searchForOneOccurrenceElement(int[] a, int n) {

		int low = 0;
		int high = n - 1;

		while (low <= high) {

			int mid = (low + high) >> 1;

			if (mid % 2 == 0 && mid + 1 < n && a[mid] == a[mid + 1]
					|| mid % 2 == 1 && mid - 1 >= 0 && a[mid] == a[mid - 1]) {

				low = mid + 1;

			} else {
				high = mid - 1;

			}

			if (mid + 1 < n && mid - 1 >= 0 && a[mid] != a[mid + 1] && a[mid] != a[mid - 1]) {
				return a[mid];
			}
		}

		return -1;

	}

}
