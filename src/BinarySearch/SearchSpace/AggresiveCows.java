package BinarySearch.SearchSpace;

public class AggresiveCows {

	private static boolean isPossible(int[] a, int n, int minDist, int cows) {

		int countCows = 1;
		int lastPlacedCows = a[0];
		for (int i = 1; i < n; i++) {
			if (a[i] - lastPlacedCows >= minDist) {
				countCows++;
				lastPlacedCows = a[i];

			}
			if (countCows == cows)
				return true;
		}
		return false;
	}

	private static int findingLargestMinimumDistance(int[] a, int n, int cows) {

		// First find the lowest and highest distances two cows can have, that will be
		// our search space

		int low = 1;
		int high = a[n - 1] - a[0];

		while (low <= high) {

			// This mid is the least distance we are assuming that all the cows will fit
			int mid = (low + high) >> 1;

			// If this is true i.e for the above minimum mid, all the cows are fitted, we
			// will check for next highest, as in the question it says return largest
			// minimum distance
			if (isPossible(a, n, mid, cows)) {
				low = mid + 1;

			} else {
				high = mid - 1;

			}
		}

		// Also in the question its clearly mention, return Largest Minimum Distance.
		// Trick - Return the "High"
		return high; // We have to return only high, because once we minimum mid satisfied, we will
						// go for next greater value so we will move the low to mid + 1. At one point
						// low , mid and high will become equal, even though we will check for next
						// greater value, at that time low will cross high and loop breaks. So at that
						// point of time high will be at the extreme satisfied point so return high.
	}

	public static void main(String[] args) {

		// You have to place "K" cows in a given Array consist of Distance, from that
		// 1st you have to take least distance, same way you have to try for different
		// combinations by placing cows at different distances and collect all the least
		// distance and then at the end from all the least distance "return" the Highest
		// Distance

		// It will only work if the distance are given in sorted order, if not given
		// please sort the coordinates at the beginning

		int a[] = { 1, 2, 4, 8, 9 };
		int k = 3;
		System.out.println(findingLargestMinimumDistance(a, a.length, k));
	}

}
