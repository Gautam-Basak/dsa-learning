package Arrays.Hard;

import java.util.ArrayList;

//Meaning - Count the number of pairs for which a[i] > a[i+1]
//If the given array is sorted in ascending oder, the count will be zero and if the array is sorted in
//decreasing order the count will be maximum.
public class CountInversionInArray {

	public static void main(String[] args) {

		int a[] = { 3, 2, 1 };
		int n = a.length;
		ArrayList<Integer> temp = new ArrayList<>();

		// 1. Brute Force
		// Use two for loop and check if a[i] > a[j] where j start from i+1, and keep
		// the counting.

		// 2. Optimal Solution.
		// Use merge sort and and after sorting it keep the count.

		System.out.println(mergeSort(a, temp, 0, n - 1));

	}

	private static int mergeSort(int[] a, ArrayList<Integer> temp, int low, int high) {

		int count = 0;
		if (high > low) {

			int mid = (low + high) / 2;

			count += mergeSort(a, temp, low, mid);
			count += mergeSort(a, temp, mid + 1, high);
			count += merge(a, temp, low, mid, high);
		}
		return count;

	}

	private static int merge(int[] a, ArrayList<Integer> temp, int low, int mid, int high) {

		int count = 0;
		int left = low;
		int right = mid + 1;

		while (left <= mid && right <= high) {
			if (a[left] < a[right]) {
				temp.add(a[left]);
				left++;
			} else {
				temp.add(a[right]);
				count = count + (mid - left + 1);
			}
		}

		while (left <= mid) {
			temp.add(a[left]);
			left++;
		}

		while (right <= high) {
			temp.add(a[right]);
			right++;
		}

		for (int i = low; i <= high; i++) {
			a[i] = temp.get(i - low);
		}
		return count;
	}

}
