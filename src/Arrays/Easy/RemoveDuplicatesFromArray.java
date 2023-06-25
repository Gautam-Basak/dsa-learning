package Arrays.Easy;

import java.util.HashSet;

public class RemoveDuplicatesFromArray {

	// Brute Force Solution
	static int removeDuplicates(int[] arr) {
		HashSet<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
		}
		// We can directly return the set also.
		System.out.println(set);

		// Else we can do the process
		int k = set.size();
		int j = 0;
		for (int x : set) {
			arr[j++] = x;
		}
		return k;
	}

	// Optimal Solution
	private static int removeDuplicatesOptimal(int[] arr) {

		int i = 0;
		for (int j = 1; j < arr.length; j++) {
			if (arr[i] != arr[j]) {
				i++;
				arr[i] = arr[j];
			}
		}
		return i + 1;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 1, 2, 2, 2, 3, 3 };

		// 1. Brute Force(Using Set)
		// TC = O(n*log(n))+O(n)
		// SC = O(n)
		/**
		 * int k1 = removeDuplicates(arr); System.out.println("The array after removing
		 * duplicate elements is "); for (int i = 0; i < k1; i++) {
		 * System.out.print(arr[i] + " "); }
		 **/

		// 2. Optimal Solution(Using Two Pointers)
		// TC = O(n)
		// SC = O(1)
		int k2 = removeDuplicatesOptimal(arr);
		System.out.println("\nThe array after removing duplicate elements is ");
		for (int i = 0; i < k2; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
