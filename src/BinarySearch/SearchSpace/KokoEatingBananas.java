package BinarySearch.SearchSpace;

public class KokoEatingBananas {

	private static int findMinimumSpeedToCompleteAllTheBananasWithInGivenTime(int[] a, int n, int hours) {

		int low = 0;
		int high = Integer.MIN_VALUE;

		for (int val : a) {
			high = Math.max(val, high) - low;
		}

		if (hours < n)
			return -1;

		if (hours == n)
			return a[n - 1];

		while (low <= high) {

			int mid = low + (high - low) / 2;

			// As we need to find minimum speed, so if isPossible return true, we will
			// reduce the mid
			if (isPossible(a, mid, hours)) {

				high = mid - 1;
			} else {

				low = mid + 1;
			}

		}
		return low;
	}

	private static boolean isPossible(int[] a, int minSpeed, int hours) {

		int time = 0;
		for (int i = 0; i < a.length; i++) {

			time += (int) Math.ceil((a[i] * 1.0) / minSpeed);
			// int ceilTime = (a[i]%minSpeed) != 0 ? (a[i]/minSpeed + 1):(a[i]/minSpeed);
			// += ceilTime;
		}
		return time <= hours;
	}

	public static void main(String[] args) {

		// Given N piles of bananas, the ith pile has piles[i] bananas and H hours time
		// until guards return (N <= H). Find the minimum (S) bananas to eat per hour
		// such that Koko can eat all the bananas within H hours. Each hour, Koko
		// chooses some pile of bananas and eats S bananas from that pile. If the pile
		// has less than S bananas, then she consumes all of them, and wont eat any more
		// bananas during that hour.

		// If given array is sorted, there won't be any issue finding the minimum and
		// maximum search space.
		// If in case is not sorted we will run for loop and find the low and max vale
		// for search space.

		// Even if the array is not sorted, we can use Binary search because the search
		// is on the minimum and maximum bananas and not on the index

		int a[] = { 7, 3, 6, 11 };
		int hours = 8;

		System.out.println(findMinimumSpeedToCompleteAllTheBananasWithInGivenTime(a, a.length, hours));

	}

}
