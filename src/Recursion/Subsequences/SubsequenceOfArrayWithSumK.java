package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceOfArrayWithSumK {

	private static void subSequenceWithSumK(int index, int[] a, int n, List<Integer> list, int sum, int initialSum) {

		if (index == n) {
			if (initialSum == sum)
				System.out.print(list);
			return;
		}

		list.add(a[index]);
		initialSum = initialSum + a[index];
		subSequenceWithSumK(index + 1, a, n, list, sum, initialSum);
		list.remove(list.size() - 1);
		initialSum = initialSum - a[index];
		subSequenceWithSumK(index + 1, a, n, list, sum, initialSum);

	}

	public static void main(String[] args) {

		int arr[] = {1, 1, 1, 2, 4, 4 };
		int n = arr.length;
		int sum = 4;
		List<Integer> list = new ArrayList<>();
		subSequenceWithSumK(0, arr, n, list, sum, 0);

	}

}
