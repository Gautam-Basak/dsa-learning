package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class NumberOfSubArraysWithSumK {

	public static void main(String[] args) {

		int[] a = { 3, 1, 2, 4 };
		int k = 6;

		// 1. Brute Force
		// - 1st for loop (i - > 0 to n-1), 2nd for loop (j - > i to n-1)
		// and 3rd for loop between i to j which gives sum=k and increase the count.

		// 2. Better Solution
		// - 1st for loop (i - > 0 to n-1), 2nd for loop (j - > i to n-1)
		// sum = sum + a[j], if sum=k, increase the count.

		// 2. Optimal Solution
		System.out.println(countSubArray(a, k));
	}

	private static int countSubArray(int[] a, int k) {

		int count = 0;
		int preSum = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < a.length; i++) {

			preSum += a[i];

			int rem = preSum - k;

			count += map.getOrDefault(rem, 0);

			map.put(preSum, map.getOrDefault(preSum, 0) + 1);
		}
		return count;

	}

}
