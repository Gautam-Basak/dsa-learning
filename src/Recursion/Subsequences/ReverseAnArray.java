package Recursion.Subsequences;

import java.util.Arrays;

public class ReverseAnArray {

	public static void main(String[] args) {

		int a[] = { 1, 2, 3, 4, 5, 6 };
		int n = a.length;
		System.out.println(Arrays.toString(a));
		reverseBasedOnTwoPointsButUsingSingleVariableAndRecursion(a, 0, n);

		System.out.print(Arrays.toString(a));

	}

	// Two Pointers are i and n-i-1 which is made up of Single Variable instead of Two Variables
	// Start(l) and End(e)
	private static void reverseBasedOnTwoPointsButUsingSingleVariableAndRecursion(int[] a, int i, int n) {

		int temp;
		if (i >= n / 2)
			return;
		temp = a[i];
		a[i] = a[n - i - 1];
		a[n - i - 1] = temp;
		reverseBasedOnTwoPointsButUsingSingleVariableAndRecursion(a, i + 1, n);

	}

}
