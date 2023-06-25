package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrintSumOfAllSubSequence {
	
	private void findCombinations(int ind, int sum, int[] arr, int n , List<Integer> ans) {

		if (ind == n) {
			ans.add(sum);
			return;
		}

		
			findCombinations(ind + 1, sum+arr[ind], arr, n, ans);
			
			findCombinations(ind + 1, sum, arr, n, ans);
			
		
	}

	public List<Integer> combinationSum(int[] arr, int n) {
		List<Integer> ans = new ArrayList<>();
		
		findCombinations(0, 0, arr, n, ans);
		Arrays.sort(arr);
		return ans;
	}

	public static void main(String[] args) {
		int arr[] = { 1, 2 };
		int n = arr.length;
		
		PrintSumOfAllSubSequence sol = new PrintSumOfAllSubSequence();
		List<Integer> ls = sol.combinationSum(arr, n);
		System.out.println(ls);

	}

}
