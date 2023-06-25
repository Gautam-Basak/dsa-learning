package Arrays.Hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NubmerOfSubArraysWithXORk {

	public static void main(String[] args) {

		// 1. Brute Force
		// Use three loops(i and j to loop through the elements and k to get the range
		// between i and j
		// for which xor ^ a[j] will be equal to given value and increase the count.

		// 2. Better Solution
		// Same as Brute Force, instead use two loops and get the xor and compare with
		// the given value,
		// if found equal increase the count.

		// 3. Optimal Solution.
		// Use one loop and hashing (for every iteration xor it(xr ^ a[i]) and hash it.
		// Then compare if any xor value is present in the hashmap previously using
		// formula k ^ xr,
		// where k is the given value, like we did for any other subarray problem.
		// Same as NumberOfSubArraysWithSumK in Medium Array Problem

		int a[] = { 4, 2, 2, 6, 4 };
		int n = a.length;
		int k = 6;
		
		System.out.println(countSubArray(a, n, k));
	}

	private static int countSubArray(int[] a, int n, int k) {

		int count = 0;
		int xr = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(xr, 1);
		for (int i = 0; i < n; i++) {

			xr ^= a[i];

			int x = xr ^ k;

			count += map.getOrDefault(x, 0);

			map.put(xr, map.getOrDefault(xr, 0) + 1);
		}
		return count;

	}

}
