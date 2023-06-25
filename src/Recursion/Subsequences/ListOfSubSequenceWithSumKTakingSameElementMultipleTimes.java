package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfSubSequenceWithSumKTakingSameElementMultipleTimes {

	private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

		if (ind == arr.length) {
			if (target == 0) {
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		if (arr[ind] <= target) {
			ds.add(arr[ind]);
			findCombinations(ind, arr, target - arr[ind], ans, ds);
			ds.remove(ds.size() - 1);
		}
		findCombinations(ind + 1, arr, target, ans, ds);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	public static void main(String[] args) {

		int arr[] = { 2, 2, 1, 1 };
		int target = 4;

		// We can do it in Simple Way as before but it is been done based on LeetCode
		// Function Calling.

		ListOfSubSequenceWithSumKTakingSameElementMultipleTimes sol = new ListOfSubSequenceWithSumKTakingSameElementMultipleTimes();
		List<List<Integer>> ls = sol.combinationSum(arr, target);
		System.out.println("Combinations are: ");
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.get(i).size(); j++) {
				System.out.print(ls.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}
