package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergerOverlappingIntervals {

	// 1. Brute Force
	// Steps -
	// a) Sort the array
	// b) Iterate over the array
	// c) Compare the first element of second interval to the second element of
	// first interval and if it is
	// found smaller or equal then increase the interval and save it in the ans.
	// d) Then go the next internal and compare the second element with the second
	// element of the last interval
	// of the ans and if it is found smaller or equal skip and increment the
	// counter.
	private static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {

		Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < arr.length; i++) {
			// 2nd element of the 1st interval(point number c)
			int start = arr[i][0];
			// 1st element of the second interval(point number c)
			int end = arr[i][1];

			if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
				continue;
			}
			for (int j = i + 1; j < arr.length; j++) {
				if (end >= arr[j][0]) {
					end = Math.max(end, arr[j][1]);
				} else
					break;
			}
			ans.add(Arrays.asList(start, end));
		}

		return ans;
	}

	public static List<List<Integer>> mergeOverlappingIntervalsOptimal(int[][] arr) {
		int n = arr.length; // size of the array
		// sort the given intervals:
		Arrays.sort(arr, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		List<List<Integer>> ans = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			// if the current interval does not
			// lie in the last interval:
			if (ans.isEmpty() || arr[i][0] > ans.get(ans.size() - 1).get(1)) {
				ans.add(Arrays.asList(arr[i][0], arr[i][1]));
			}
			// if the current interval
			// lies in the last interval:
			else {
				ans.get(ans.size() - 1).set(1, Math.max(ans.get(ans.size() - 1).get(1), arr[i][1]));
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		int[][] arr = { { 1, 3 }, { 8, 10 }, { 2, 6 }, { 15, 18 } };
		/**
		 * List<List<Integer>> ans = mergeOverlappingIntervals(arr);
		 * System.out.print("The merged intervals are: \n"); for (List<Integer> it :
		 * ans) { System.out.print("[" + it.get(0) + ", " + it.get(1) + "] "); }
		 * System.out.println();
		 * 
		 **/

		
		//Optimal Solution
		//Use single for loop, staying at current element and checking for others
		List<List<Integer>> ans = mergeOverlappingIntervalsOptimal(arr);
		System.out.print("The merged intervals are: \n");
		for (List<Integer> it : ans) {
			System.out.print("[" + it.get(0) + ", " + it.get(1) + "] ");
		}
		System.out.println();
	}

}
