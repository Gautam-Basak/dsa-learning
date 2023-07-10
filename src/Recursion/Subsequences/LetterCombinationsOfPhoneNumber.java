package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	public static List<String> letterCombinations(String digits) {

		List<String> res = new ArrayList<>();

		if (digits.length() == 0)
			return res;

		Map<Character, String> map = new HashMap<>();
		map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		
		solve("", 0, digits, digits.length(), res, map);

		return res;
	}

	private static void solve(String s, int ind, String digit, int len, List<String> res, Map<Character, String> map) {

		if (ind == len) {
			res.add(s);
			return;
		}
		char ch = digit.charAt(ind);
		String str = map.get(ch);
		for (int i = 0; i < str.length(); i++) {
			solve(s + str.charAt(i), ind + 1, digit, len, res, map);
		}
	}

	public static void main(String args[]) {

		String s = "23";
		List<String> list = letterCombinations(s);

		for (String str : list) {
			System.out.println(str);
		}
	}
}
