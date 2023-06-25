package Arrays.Medium;

import java.util.Arrays;
import java.util.Collections;

public class NextPermutation {

	public static void main(String[] args) {
		
		//1. Brute Force
		// Get all the permutation(TC = N!*N, N!= No. of permutations and N = Arranging the N elements everytime)
		// SC = O(1)
		
		
		//2. Better Solution
		// In C++ we have Inbuilt Function(next_permutation) using that we can get
		
		Integer a[] = { 2, 1, 5, 4, 3, 0, 0 };
		
		//3. Optimal Solution
		//- Get the dips or break point, swap the dips index with the smallest index 
		//(which will be available in the longest prefix area) but greater than dips.
		//After Swaping, reverse the sub-array between index+1 to end.
		//If the given array is the last permutation, only reverse the array and return. 
		findNextPermutation(a, a.length);
		System.out.println(Arrays.toString(a));
	}

	private static Integer[] findNextPermutation(Integer[] a, int n) {

		int index = -1;
		for (int i = n - 2; i >= 0; i--) {
			if (a[i] < a[i + 1]) {
				index = i;
				break;
			}
		}

		if (index == -1) {
			Collections.reverse(Arrays.asList(a));
			return a;
		}

		for (int i = n - 1; i > index; i--) {
			if (a[i] > a[index]) {
				int temp = a[i];
				a[i] = a[index];
				a[index] = temp;
				break;
			}
		}

		Integer subArray[] = Arrays.copyOfRange(a, index + 1, n);
		Collections.reverse(Arrays.asList(subArray));
		return a;

	}

}
