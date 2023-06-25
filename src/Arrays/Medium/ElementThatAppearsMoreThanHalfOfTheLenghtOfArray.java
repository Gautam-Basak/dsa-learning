package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class ElementThatAppearsMoreThanHalfOfTheLenghtOfArray {

	public static int majorityElementBrute(int[] v) {
		// size of the given array:
		int n = v.length;

		for (int i = 0; i < n; i++) {
			// selected element is v[i]
			int cnt = 0;
			for (int j = 0; j < n; j++) {
				// counting the frequency of v[i]
				if (v[j] == v[i]) {
					cnt++;
				}
			}

			// check if frquency is greater than n/2:
			if (cnt > (n / 2))
				return v[i];
		}

		return -1;
	}

	public static int majorityElementBetter(int[] v) {
		// size of the given array:
		int n = v.length;

		// declaring a map:
		HashMap<Integer, Integer> mpp = new HashMap<>();

		// storing the elements with its occurnce:
		for (int i = 0; i < n; i++) {
			int value = mpp.getOrDefault(v[i], 0);
			mpp.put(v[i], value + 1);
		}

		// searching for the majority element:
		for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
			if (it.getValue() > (n / 2)) {
				return it.getKey();
			}
		}

		return -1;
	}

	private static int majorityElementOptimal(int[] arr) {

		int count = 0;
		int n = arr.length;
		int element = 0;

		for (int i = 0; i < n; i++) {

			if (count == 0) {
				count = 1;
				element = arr[i];
			} else if (element == arr[i])
				count++;
			else
				count--;
		}

		int count1 = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == element)
				count1++;
		}
		if (count1 > n / 2)
			return element;
		return -1;

	}

	public static void main(String[] args) {
		int[] arr = { 2, 2, 1, 1, 1, 2, 2 };

		/**
		 * Brute Force int ans = majorityElementBrute(arr); System.out.println("The
		 * majority element is: " + ans);
		 **/

		/**
		 * Better Solution int ans = majorityElementBetter(arr); System.out.println("The
		 * majority element is: " + ans);
		 **/

		// Optimal Solution - Moore's Voting Algorithm
		// Take an element and increase the count, if you get same element increase the count,
		// if not decrease the count(if it becomes zero) again repeat the same process.
		int ans = majorityElementOptimal(arr);
		System.out.println("The majority element is: " + ans);
	}

}
