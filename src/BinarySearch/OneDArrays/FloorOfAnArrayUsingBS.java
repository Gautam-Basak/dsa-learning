package BinarySearch.OneDArrays;

public class FloorOfAnArrayUsingBS {

	public static void main(String[] args) {
		// Floor - Largest element smaller than or equal to target.

		// T.C = O(log n)

		int a[] = { 2, 5, 7, 9, 10, 14, 16, 18, 20, 22, 24 };
		int target = 13;

		System.out.println(floorBinarySearch(a, target));

	}

	private static int floorBinarySearch(int[] a, int target) {

		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2; 
			
			//What if the target element is smaller than smallest element in the array
			if (target < a[0])
				return -1;
			if (target < a[mid]) { 
				end = mid - 1;
			} else if (target > a[mid]) {
				start = mid + 1;
			} else
				return a[mid];
		}

		return a[end];
	}

}