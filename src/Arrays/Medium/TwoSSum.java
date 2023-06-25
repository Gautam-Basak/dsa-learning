package Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSSum {

	public static void main(String[] args) {
		int a[] = { 4, 2, 5, 1, 7, 6, 6 };
		int k = 10;

		/***
		 * Brute Force Using Two Loops 
		 * System.out.println(twoSSumExistBrute(a, k));
		 * 
		 * System.out.println(Arrays.toString(returnIndexIfTwoSSumExistBrute(a, k)));
		 ***/

		/***
		 * Better Solution Using Hashing 
		 * System.out.println(twoSSumExistBetter(a, k));
		 * 
		 * System.out.println(Arrays.toString(returnIndexIfTwoSSumExistBetter(a, k)));
		 ***/

		// Optimal Solution Using Two Pointers
		// With Optimal Solution The Second Type Of Problem Cannot Be Achieved
		System.out.println(twoSSumExistOptimal(a, k));
	}

	private static String twoSSumExist(int[] a, int k) {

		for (int i = 0; i < a.length; i++) {

			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == k)
					return "Yes";
			}

		}
		return "No";
	}

	private static int[] returnIndexIfTwoSSumExist(int[] a, int k) {

		int ans[] = new int[2];
		ans[0] = -1;
		ans[1] = -1;
		for (int i = 0; i < a.length; i++) {

			for (int j = i + 1; j < a.length; j++) {
				if (a[i] + a[j] == k) {
					ans[0] = i;
					ans[1] = j;
					return ans;
				}
			}

		}
		return ans;
	}

	private static String twoSSumExistBetter(int[] a, int target) {

		Map<Integer, Integer> map = new HashMap<>();
		int moreNeeded = 0;

		for (int i = 0; i < a.length; i++) {

			moreNeeded = target - a[i];
			if (map.containsKey(moreNeeded))
				return "Yes";

			map.put(a[i], i);
		}

		return "No";
	}

	private static int[] returnIndexIfTwoSSumExistBetter(int[] a, int target) {

		int ans[] = new int[2];
		ans[0] = -1;
		ans[1] = -1;

		Map<Integer, Integer> map = new HashMap<>();
		int moreNeeded = 0;

		for (int i = 0; i < a.length; i++) {

			moreNeeded = target - a[i];
			if (map.containsKey(moreNeeded)) {

				ans[0] = map.get(moreNeeded);
				ans[1] = i;
				return ans;
			}

			map.put(a[i], i);
		}
		return ans;
	}

	private static String twoSSumExistOptimal(int[] a, int target) {

		Arrays.sort(a);
		int left = 0, right = a.length - 1;

		while (left <= right) {
			int sum = a[left] + a[right];
			if (sum < target)
				left++;
			else if (sum > target)
				right--;
			else
				return "Yes";

		}
		return "No";
	}

}