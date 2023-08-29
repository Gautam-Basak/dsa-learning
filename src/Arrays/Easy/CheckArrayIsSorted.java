package Arrays.Easy;

public class CheckArrayIsSorted {
	
	private static boolean checkSortedOrNot(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1])
				return false;

		}
		return true;

	}

	public static void main(String[] args) {

		// 1. Brute Force (Using two loops and Comparing)
		// TC = O(N^2)
		// SC = O(1)
		
		
		
		int arr[] = { 1, 5, 4, 6, 3, 9, 7 };
		
		// 2.Optimal Solution
		// TC = O(N)
		// SC = O(1)
		if (checkSortedOrNot(arr))
			System.out.println("Sorted");
		else
			System.out.println("Not Sorted");

	}

}
