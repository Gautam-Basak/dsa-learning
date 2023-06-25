package BinarySearch.SearchSpace;

public class FindKthElementInTwoSortedArrays {

	public static void main(String[] args) {

		int a[] = { 2, 3, 4, 5, 6, 7, 7 };
		int b[] = { 4, 6, 8, 10, 13, 18 };
		int k = 5;

		System.out.println(findKthElementInTwoSortedArray(a, a.length, b, b.length, k));

	}

	private static int findKthElementInTwoSortedArray(int[] a, int m, int[] b, int n, int k) {

		if (m > n) {

			return findKthElementInTwoSortedArray(b, b.length, a, a.length, k);
		}

		int low = Math.max(0, k - n);
		int high = Math.min(k, m);

		while (low <= high) {

			int cut1 = (low + high) >> 1;
			int cut2 = k - cut1;

			int l1 = cut1 == 0 ? Integer.MIN_VALUE : a[cut1 - 1];
			int l2 = cut2 == 0 ? Integer.MIN_VALUE : b[cut2 - 1];
			int r1 = cut1 == m ? Integer.MAX_VALUE : a[cut1];
			int r2 = cut2 == n ? Integer.MAX_VALUE : b[cut2];

			if (l1 <= r2 && l2 <= r1) {
				return Math.max(l1, l2);

			} else if (l1 > r2) {
				high = cut1 - 1;

			} else
				low = cut1 + 1;
		}

		return -1;
	}

}
