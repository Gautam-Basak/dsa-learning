package BinarySearch.SearchSpace;

public class BookAllocation {

	private static boolean isPossible(int[] a, int pages, int students) {

		int allocatedStudents = 1;
		int pagesAllocated = 0;

		for (int i = 0; i < a.length; i++) {

			if (a[i] > pages)
				return false;
			if (pagesAllocated + a[i] > pages) {
				allocatedStudents += 1;
				pagesAllocated = a[i];

			} else {
				pagesAllocated += a[i];

			}

			if (allocatedStudents > students)
				return false;

		}
		return true;
	}

	private static int findingSmallestMaximumAllocation(int[] a, int n, int students) {

		if (students > a.length) {
			return -1;

		}

		int low = a[0];
		int high = 0;
		for (int i = 0; i < n; i++) {
			high = high + a[i];
		}

		while (low <= high) {
			int mid = (low + high) >> 1;

			if (isPossible(a, mid, students)) {
				high = mid - 1;

			} else {
				low = mid + 1;

			}

		}
		return low;
	}

	public static void main(String[] args) {

		// Given Array has number of pages in each books.
		// First you need to allocate maximum number of books(which indirectly means max
		// no. of pages) among given "K" students, same way you need to try for
		// different combinations and collect all the maximum allocation, and then at
		// the end from all the maximum allocations "return" the minimum value.

		// The question comes with multiple conditions:-
		// 1. A whole book have to allocate to one student
		// 1. Minimum a Book will be allocated to one student
		// 2. Allocation should be in contiguous manner

		// It will only work if the distance are given in sorted order, if not given
		// please sort the coordinates at the beginning

		int a[] = { 12, 34, 67, 90 };
		int k = 2;
		System.out.println(findingSmallestMaximumAllocation(a, a.length, k));

	}

}
