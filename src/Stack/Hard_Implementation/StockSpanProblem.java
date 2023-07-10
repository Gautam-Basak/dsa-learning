package Stack.Hard_Implementation;

import java.util.Stack;

public class StockSpanProblem {

	private static void printSpan(int[] arr, int n) {

		Stack<Integer> s = new Stack<>();

		s.push(0);
		System.out.print(1 + " ");

		for (int i = 1; i < n; i++) {

			while (s.isEmpty() == false && arr[s.peek()] <= arr[i]) {

				s.pop();
			}

			int span = s.isEmpty() ? i + 1 : i - s.peek();
			System.out.print(span + " ");
			s.push(i);
		}
	}

	public static void main(String[] args) {

		// Span is total number of consecutive elements smaller than or equal to the
		// current element on the left of current element including the current
		// element.
		// First element always have a span 1.
		// a[] = {40, 50, 10, 20, 60} then span = 1, 2, 1, 2, 5

		// Naive Solution
		// Take span equal to 1 for 1st element.
		// Use two for loops and check if the up to which previous element, the current
		// element is small and increase the span count

		// Optimal Solution
		// Use Stack to keep track of the indexes of all the elements until you
		// encounter a current which is greater than atleast one previous element, once
		// you encounter remove the indexes upto that element from the stack and push
		// the index of current greater element. (As stack is used to remove the top
		// element one by one easily)

		int[] arr = new int[] { 18, 12, 13, 14, 11, 16 };

		printSpan(arr, arr.length);
	}

}
