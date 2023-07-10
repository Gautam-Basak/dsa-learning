package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfArray {

	private static void subSequence(int index, int[] a, int n, List<Integer> list) {

		if (index == n) {

			System.out.println(list);
			return;
		}

		list.add(a[index]);
		subSequence(index + 1, a, n, list);
		list.remove(list.size() - 1);
		subSequence(index + 1, a, n, list);

	}

	public static void main(String[] args) {

		int a[] = { 1, 2, 3 };
		int n = a.length;
		List<Integer> list = new ArrayList<>();
		subSequence(0, a, n, list);

	}

}
