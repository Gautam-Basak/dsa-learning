package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumK {

	public static void main(String[] args) {

		int a[] = { 1, 1, 1, 4, 6 };
		int k = 6;

		// Better Solution
		// System.out.println(longestSumWithSumKBetterSolution(a, k));

		// Optimal Solution
		System.out.println(longestSumWithSumKOptimalSolution(a, k));

	}

	private static int longestSumWithSumKBetterSolution(int[] a, int k) {

		Map<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		int maxLenght = 0;

		for (int i = 0; i < a.length; i++) {

			sum += a[i];
			if (sum == k) {
				maxLenght = Math.max(maxLenght, i + 1);
			}
			int rem = sum - k;
			if (map.containsKey(rem)) {
				int len = i - map.get(rem);
				maxLenght = Math.max(maxLenght, len);
			}
			if (!map.containsKey(sum))
				map.put(sum, i);
		}
		return maxLenght;
	}

	private static int longestSumWithSumKOptimalSolution(int[] a, int k) {

		int left = 0, right = 0;
		int n = a.length;
		int sum = a[0];
		int maxLenght = 0;
		while (right < n) {

			while (sum > k && left <= right) {
				sum -= a[left];
				left++;
			}
			if (sum == k) {
				maxLenght = Math.max(maxLenght, right - left + 1);
			}
			right++;
			if (right < n) {
				sum += a[right];
			}
		}

		return maxLenght;
	}

}
