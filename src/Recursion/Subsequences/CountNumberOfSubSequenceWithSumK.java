package Recursion.Subsequences;

public class CountNumberOfSubSequenceWithSumK {

	private static int countSubSequenceWithSumK(int index, int[] arr, int n, int sum, int initialSum) {

		if (index == n) {
			if (initialSum == sum) {
				return 1;
			} else
				return 0;
		}

		initialSum = initialSum + arr[index];
		int l = countSubSequenceWithSumK(index + 1, arr, n, sum, initialSum);

		initialSum = initialSum - arr[index];
		int m = countSubSequenceWithSumK(index + 1, arr, n, sum, initialSum);

		return l + m;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 1 };
		int n = arr.length;
		int sum = 2;

		System.out.println(countSubSequenceWithSumK(0, arr, n, sum, 0));
	}

}
