package BinarySearch.SearchSpace;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {

		// If the number of elements are even suppose 10 then :-
		// Median = (5th + 6th element)/2 or (4th Index + 5th Index's elements)/2

		// If the number of elements are odd suppose 11 then :-
		// Median = 5th element or 5th Index's element

		// To find the mid we will use this formula - (n+m+1)/2

		// If the length is odd i.e n+m is odd (example 5+6=11), then using above
		// formula we will get 6,
		// which is our partition and to find the median we will use Math.Max(l1, l2).

		// If the length is even i.e n+m is even (example 5+5=10), then using above
		// formula we will get (10+1)/2 = 5.,
		// which is our partition and to find the median we will use
		// (Math.Max(l1, l2) + Math.Min(r1,r2))/2

		int a[] = { 1, 2, 3, 4, 5, 6 };
		int b[] = { 7, 8, 9, 10 };

		System.out.println(median(a, a.length, b, b.length));

	}

	private static double median(int[] a, int m, int[] b, int n) {

		if (m > n) {

			return median(b, b.length, a, a.length);
		}

		int low = 0;
		int high = m;

		while (low <= high) {

			int cut1 = (low + high) / 2;
			int cut2 = (m + n + 1) / 2 - cut1;

			int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
			int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
			int r1 = cut1 == m ? Integer.MAX_VALUE : a[cut1];
			int r2 = cut2 == n ? Integer.MAX_VALUE : b[cut2];

			if (l1 <= r2 && l2 <= r1) {
				if ((m + n) % 2 == 0) {
					return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

				} else {

					return Math.max(l1, l2);
				}
			} else if (l1 > r2) {
				high = cut1 - 1;

			} else {
				low = cut1 + 1;

			}

		}
		return -1;

	}

}
