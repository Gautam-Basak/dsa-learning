package Stack.Hard_Implementation;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class MaximumOfAllSubArraysOfSizeK {

	/***
	 * // Brute Force private static void maxInWindowOfSizeKBruteForce(int[] arr,
	 * int left, int right, ArrayList<Integer> max) {
	 * 
	 * int localMax = Integer.MIN_VALUE;
	 * 
	 * for (int i = left; i <= right; i++) {
	 * 
	 * localMax = Math.max(localMax, arr[i]);
	 * 
	 * } max.add(localMax); }
	 * 
	 * // Brute Force private static ArrayList<Integer> maxSlidingWindow(int[] arr,
	 * int k) {
	 * 
	 * int left = 0, right = 0; ArrayList<Integer> max = new ArrayList<>();
	 * 
	 * while (right < k - 1) { right++; }
	 * 
	 * while (right < arr.length) { getMaxInBetweenLeftAndRight(arr, left, right,
	 * max); left++; right++; }
	 * 
	 * return max; }
	 ***/

	public static void main(String[] args) {

		int arr[] = { 4, 0, -1, 3, 5, 3, 6, 8 };
		int k = 3;
		ArrayList<Integer> ans;

		// Brute Force
		// T.C = O(N*N), S.C = O(k)

		/***
		 * ans = maxInWindowOfSizeKBruteForce(arr, k);
		 * 
		 * for (i = 0; i < ans.size(); i++) { System.out.print(ans.get(i));
		 * 
		 * if (i < ans.size() - 1) System.out.print(" "); }
		 ***/

		// Optimal Solution
		// T.C = O(N*N), S.C = O(k)
		int ans1[];
		ans1 = maxINSlidingWindowOfSizeKOptimal(arr, k);

		System.out.println("Maximum element in every " + k + " window ");
		for (int i = 0; i < ans1.length; i++) {
			System.out.print(ans1[i] + "  ");

		}

	}
	
	//Optimal Solution
	private static int[] maxINSlidingWindowOfSizeKOptimal(int[] arr, int k) {

		int n = arr.length;
		int res[] = new int[n - k + 1];
		int ri = 0;

		Deque<Integer> dq = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {

			while (!dq.isEmpty() && dq.peek() == i - k) {
				dq.poll();
			}

			while (!dq.isEmpty() && arr[dq.peek()] <= arr[i]) {
				dq.pollLast();
			}
			dq.offer(i);

			if (i >= k - 1) {
				res[ri++] = arr[dq.peek()];
			}
		}
		return res;
	}

}
