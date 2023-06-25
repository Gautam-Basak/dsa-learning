package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumsThatAddsToZero {

	public static void main(String[] args) {

		// 1. Brute Force
		// Use three for loops and add a[i]+a[j]+a[k], if the sum is zero return
		// element.

		// 2. Better Solution
		// Use two for loops(i and j) and get the third element from Hash Table
		// (added all the elements in Hash Table at the beginning).
		// To avoid duplicate, after running the loop remove the same element from the
		// Hash Table
		// so that while picking the third element it shouldn't pick the same element.

		// Optimal Solution
		// Sort the Array, Use one loop and two pointers and get the sum if the sum is
		// lesser increase
		// the left pointer or if the sum is greater than decrease the right pointer.
		int a[] = { 1, -2, 1, 0, 1, -1, 3, -2, -1, -3, 0, 4 };
		int n = a.length;
		
		List<List<Integer>> finalAns;
		finalAns = generateTriplet(a, n);
		
		for (List<Integer> it : finalAns) {
			for (int element : it) {
				System.out.print(element);
			}

			System.out.println();
		}
	}

	private static List<List<Integer>> generateTriplet(int[] a, int n) {

		Arrays.sort(a);

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			if (i == 0 || (i > 0 && a[i] != a[i - 1])) {

				int low = i + 1, high = n - 1, sum = 0 - a[i];

				while (low < high) {
					if (a[low] + a[high] == sum) {
						ans.add(Arrays.asList(a[i], a[low], a[high]));

						while (low < high && a[low] == a[low + 1])
							low++;
						while (low < high && a[high] == a[high - 1])
							high--;

						low++;
						high--;
					} else if (a[low] + a[high] < sum)
						low++;
					else
						high--;
				}
			}
		}

		return ans;
	}

}
