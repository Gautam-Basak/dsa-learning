package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.List;

public class ListOfAllPermutationTakingAllElementsWithLessSpaceComplexcity {

	private void findCombinations(int ind, int[] arr, List<List<Integer>> ans) {

		if (ind == arr.length) {

			List<Integer> ds = new ArrayList<>();
			for (int i = 0; i < arr.length; i++) {
				ds.add(arr[i]);
			}
			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = ind; i < arr.length; i++) {
			swap(i, ind, arr);
			findCombinations(ind + 1, arr, ans);
			swap(i, ind, arr);
		}

	}

	private void swap(int i, int j, int[] arr) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;

	}

	public List<List<Integer>> combinationSum(int[] candidates) {
		List<List<Integer>> ans = new ArrayList<>();
		findCombinations(0, candidates, ans);
		return ans;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3 };

		ListOfAllPermutationTakingAllElementsWithLessSpaceComplexcity sol = new ListOfAllPermutationTakingAllElementsWithLessSpaceComplexcity();
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
