package Arrays.Medium;

import java.util.Arrays;

public class SortAnArayOfZerosOnesAndTwos {

	public static void main(String[] args) {

		int a[] = { 1, 0, 2, 1, 1, 1, 1, 2, 0, 0, 2, 2, 1, 0 };

		// Sort the array with any Algorithm example Merge Sort or Quick Sort
		// sortingZeroOneAndTwoBrute(a);

		// Better Solution (Keep Counting of the elements Using For Loop then Put Back
		// them Accordingly
		// sortingZeroOneAndTwoBetter(a);
		// System.out.println(Arrays.toString(a));

		// Optimal Solution - Dutch National Flag Algorithm
		sortingZeroOneAndTwoOptimal(a);
		System.out.println(Arrays.toString(a));

	}

	private static void sortingZeroOneAndTwoBrute(int[] a) {

	}

	private static void sortingZeroOneAndTwoBetter(int[] a) {

		int count0 = 0, count1 = 0, count2 = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0)
				count0++;
			else if (a[i] == 1)
				count1++;
			else
				count2++;
		}
		for (int i = 0; i < count0; i++) {
			a[i] = 0;
		}
		for (int i = count0; i < count0 + count1; i++) {
			a[i] = 1;
		}
		for (int i = count0 + count1; i < a.length; i++) {
			a[i] = 2;
		}

	}

	private static void sortingZeroOneAndTwoOptimal(int[] a) {

		int low = 0, mid = 0, high = a.length - 1;

		while (mid <= high) {

			if (a[mid] == 0) {
				int temp = a[low];
				a[low] = a[mid];
				a[mid] = temp;
				low++;
				mid++;
			} else if (a[mid] == 1)
				mid++;
			else {
				int temp = a[mid];
				a[mid] = a[high];
				a[high] = temp;
				high--;
			}

		}

	}

}
