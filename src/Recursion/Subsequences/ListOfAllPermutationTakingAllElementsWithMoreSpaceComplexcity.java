package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOfAllPermutationTakingAllElementsWithMoreSpaceComplexcity {

	private void findCombinations(int[] arr, List<List<Integer>> ans, List<Integer> ds, boolean[] freq) {

		if (ds.size() == arr.length) {

			ans.add(new ArrayList<>(ds));
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if (!freq[i]) {
				freq[i] = true;
				ds.add(arr[i]);
				findCombinations(arr, ans, ds, freq);
				ds.remove(ds.size() - 1);
				freq[i] = false;
			}

		}
	}

	public List<List<Integer>> combinationSum(int[] candidates) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> ds = new ArrayList<>();
		boolean freq[] = new boolean[candidates.length];
		findCombinations(candidates, ans, ds, freq);
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };

		ListOfAllPermutationTakingAllElementsWithMoreSpaceComplexcity sol = new ListOfAllPermutationTakingAllElementsWithMoreSpaceComplexcity();
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
