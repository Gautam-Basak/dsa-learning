package Arrays.Medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {

	public static void main(String[] args) {

		int a[] = { 9, 100, 1, 101, 10, 7, 6, 8, 5, 3, 2, 1 };

		// 1. Brute Force
		// Using sorting (TC = N*LogN)
		// TC = O(N) + O(N*LogN)
		// System.out.println(findLongestConsecutiveSequenceBrute(a, a.length));
		
		
		//Optimal Solution
		System.out.println(findLongestConsecutiveSequenceOptimal(a, a.length));

	}

	private static int findLongestConsecutiveSequenceBrute(int[] a, int n) {

		Arrays.sort(a);
		int prev = a[0];
		int count = 0;
		int max = 0;

		for (int i = 1; i < n; i++) {
			if (a[i] == prev + 1) {
				count++;
			} else if (a[i] != prev)
				count = 1;

			prev = a[i];
			max = Math.max(max, count);
		}
		return max;
	}

	private static int findLongestConsecutiveSequenceOptimal(int[] a, int n) {

		HashSet<Integer> set = new HashSet<>();

		int max = 0;

		for (int element : a) {
			set.add(element);
		}

		for (int element : a) {
			if (!set.contains(element - 1)) {

				int currentElemet = element;
				int currentCount = 1;

				while (set.contains(currentElemet + 1)) {
					currentElemet = currentElemet + 1;
					currentCount = currentCount + 1;
				}

				max = Math.max(max, currentCount);

			}
		}
		return max;
	}

}
