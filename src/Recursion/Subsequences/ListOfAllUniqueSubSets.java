package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ListOfAllUniqueSubSets {

	private void findCombinations(int ind, int[] arr, List<List<Integer>> ans, List<Integer> ds) {

		ans.add(new ArrayList<>(ds));

		for (int i = ind; i < arr.length; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			ds.add(arr[i]);
			findCombinations(i + 1, arr, ans, ds);
			ds.remove(ds.size() - 1);
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		findCombinations(0, candidates, ans, new ArrayList<>());
		return ans;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3 };

		ListOfAllUniqueSubSets sol = new ListOfAllUniqueSubSets();
		List<List<Integer>> ls = sol.combinationSum(arr);
		System.out.println("Combinations are: ");
		for (int i = 0; i < ls.size(); i++) {
			for (int j = 0; j < ls.get(i).size(); j++) {
				System.out.print(ls.get(i).get(j) + " ");
			}
			System.out.println();
		}

	}

}
