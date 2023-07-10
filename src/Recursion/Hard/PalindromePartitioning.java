package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	private static void partitionHelper(int ind, String s, List<String> path, List<List<String>> res) {

		if (ind == s.length()) {
			res.add(new ArrayList<>(path));
			return;
		}

		for (int i = ind; i < s.length(); i++) {

			if (isPalindrome(ind, i, s)) {
				path.add(s.substring(ind, i + 1));
				partitionHelper(i + 1, s, path, res);
				path.remove(path.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(int start, int end, String s) {

		while (start <= end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

	private static List<List<String>> partition(String s) {

		List<List<String>> res = new ArrayList<>();
		List<String> path = new ArrayList<>();

		partitionHelper(0, s, path, res);

		return res;
	}

	public static void main(String[] args) {

		// Find all the subSets which in itself id Palindrome

		String s = "aabb";

		List<List<String>> ans = partition(s);
		System.out.print("[");
		for (int i = 0; i < ans.size(); i++) {
			System.out.print("[");
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.print("]");
		}
		System.out.print("]");
	}
}
