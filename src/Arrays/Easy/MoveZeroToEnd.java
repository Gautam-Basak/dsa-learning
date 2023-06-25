package Arrays.Easy;

public class MoveZeroToEnd {
	public static void main(String[] args) {
		int arr[] = { 1, 2, 0, 0, 1, 0, 4, 0 };
		
		// 1. Brute Force
		// TC = O(N)
		// SC = O(N)
		//zerosToEndBrute(arr);
		
		// 1. Optimal Solution
		// TC = O(N)
		// SC = O(1)
		zerosToEndOptimal(arr);

	}
	
	//Brute Force Solution
	public static void zerosToEndBrute(int[] arr) {

		int n = arr.length;
		int temp[] = new int[n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] != 0) {
				temp[k] = arr[i];
				k++;
			}
		}

		while (k < n) {
			temp[k] = 0;
			k++;
		}
		for (int i = 0; i < n; i++) {
			System.out.print(temp[i] + " ");
		}
	}
	
	//Optimal Solution
	public static void zerosToEndOptimal(int[] arr) {

		// finding first zero occurrence
		int k = 0;
		while (k < arr.length) {
			if (arr[k] == 0) {

				break;
			} else {
				k = k + 1;
			}
		}

		// finding zeros and immediate non-zero elements and swapping them
		int i = k, j = k + 1;

		while (i < arr.length && j < arr.length) {
			if (arr[j] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;

			}

			j++;

		}
		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
