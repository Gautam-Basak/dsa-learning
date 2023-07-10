package Stack.Monotonic;

import java.util.Stack;

public class NextGreater {

	public static void printNextGreater(int arr[], int n) {

		for (int i = 0; i < n; i++) {
			int j;
			for (j = i + 1; j < n; j++) {
				if (arr[j] > arr[i]) {
					System.out.print(arr[j] + " ");
					break;
				}
			}
			if (j == n)
				System.out.print(-1 + " ");
		}
		System.out.println("\n");
	}

	private static int[] printNextGreaterOptimized(int[] arr, int n) {

		int nge[] = new int[n];
		nge[n - 1] = -1;
		Stack<Integer> s = new Stack<>();
		s.push(arr[n - 1]);

		for (int i = n - 2; i >= 0; i--) {

			while (s.isEmpty() == false && s.peek() <= arr[i]) {
				s.pop();
			}

			int ng = s.isEmpty() ? -1 : s.peek();
			nge[i] = ng;
			s.push(arr[i]);
		}

		return nge;
	}

	public static void main(String[] args) {

		int[] arr = new int[] { 20, 30, 10, 5, 15 };

		// Naive Solution (Used two for loops)
		printNextGreater(arr, arr.length);

		// Optimized Solution (Used Stack)
		int arr2[] = printNextGreaterOptimized(arr, arr.length);
		System.out.println("The next greater elements are ");
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
}
