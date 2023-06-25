package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfUniqueSubSequenceWithSumKWithoutTakingSameElementMultipleTimes {

	private void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {

		if (target == 0) {
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = ind; i < arr.length; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			if (arr[i] > target)
				break;
			ds.add(arr[i]);
			findCombinations(i + 1, arr, target - arr[i], ans, ds);
			ds.remove(ds.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinations(0, candidates, target, ans, new ArrayList<>());
		return ans;
	}

	public static void main(String[] args) {

		int arr[] = { 4, 4 };
		int target = 4;

		// We can do it in Simple Way as before but it is been done based on LeetCode
		// Function Calling.

		ListOfUniqueSubSequenceWithSumKWithoutTakingSameElementMultipleTimes sol = new ListOfUniqueSubSequenceWithSumKWithoutTakingSameElementMultipleTimes();
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
