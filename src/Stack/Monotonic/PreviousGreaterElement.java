package Stack.Monotonic;

import java.util.Stack;

public class PreviousGreaterElement {

	public static void printPrevGreater(int arr[], int n) {

		for (int i = 0; i < n; i++) {
			int j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > arr[i]) {
					System.out.print(arr[j] + " ");
					break;
				}
			}
			if (j == -1)
				System.out.print(-1 + " ");
		}
		System.out.println("\n");
	}

	private static void printPrevGreaterUsingStack(int[] arr, int n) {

		Stack<Integer> s = new Stack<>();
		s.push(arr[0]);

		for (int i = 0; i < n; i++) {

			while (s.isEmpty() == false && s.peek() <= arr[i]) {
				s.pop();
			}

			int pg = s.isEmpty() ? -1 : s.peek();

			System.out.print(pg + " ");
			s.push(arr[i]);
		}

	}

	public static void main(String[] args) {

		int[] arr = new int[] { 20, 30, 10, 5, 15 };

		// Naive Solution (Used two for loops)
		printPrevGreater(arr, arr.length);

		// Optimized Solution (Used Stack)
		printPrevGreaterUsingStack(arr, arr.length);

	}

}
