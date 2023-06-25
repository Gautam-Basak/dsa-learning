package Recursion.Subsequences;

import java.util.ArrayList;
import java.util.List;

public class AnyOneSubSequenceWithSumK {

	private static boolean oneSubSequenceWithSumK(int index, int[] arr, int n, int sum, List<Integer> list,
			int initialSum) {

		if (index == n) {
			if (initialSum == sum) {
				System.out.println(list);
				return true;
			} else
				return false;
		}

		list.add(arr[index]);
		initialSum = initialSum + arr[index];
		if (oneSubSequenceWithSumK(index + 1, arr, n, sum, list, initialSum) == true)
			return true;

		list.remove(list.size() - 1);
		initialSum = initialSum - arr[index];
		if (oneSubSequenceWithSumK(index + 1, arr, n, sum, list, initialSum) == true)
			return true;

		return false;

	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 1 };
		int n = arr.length;
		int sum = 2;
		List<Integer> list = new ArrayList<>();

		oneSubSequenceWithSumK(0, arr, n, sum, list, 0);

	}

}
