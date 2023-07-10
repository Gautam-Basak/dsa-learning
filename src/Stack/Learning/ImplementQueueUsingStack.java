package Stack.Learning;

import java.util.Stack;

class MyQueue {

	Stack<Integer> s1 = new Stack<>();
	Stack<Integer> s2 = new Stack<>();

	void push(int x) {

		while (s1.empty() == false) {
			s2.push(s1.peek());

			s1.pop();
		}

		System.out.println("The element pushed is " + x);
		s1.push(x);

		while (s2.empty() == false) {
			s1.push(s2.peek());

			s2.pop();
		}
	}

	int peek() {

		if (s1.empty()) {
			System.out.println("Stack is empty");

		}

		return s1.peek();
	}

	int pop() {

		if (s1.empty()) {
			System.out.println("Stack is empty");

		}

		int val = s1.peek();

		s1.pop();
		return val;
	}

	int size() {

		return s1.size();
	}
}

class MyQueue1 {

	Stack<Integer> input = new Stack<>();
	Stack<Integer> output = new Stack<>();

	void push(int x) {

		System.out.println("The element pushed is " + x);
		input.add(x);
	}

	int pop() {

		if (output.empty()) {
			while (input.empty() == false) {
				output.push(input.peek());
				input.pop();
			}
		}
		int x = output.peek();
		output.pop();
		return x;
	}

	int peek() {

		if (output.empty()) {
			while (input.empty() == false) {
				output.push(input.peek());
				input.pop();
			}
		}

		return output.peek();
	}

	int size() {

		return output.size() + input.size();
	}
}

public class ImplementQueueUsingStack {

	public static void main(String[] args) {

		// Naive Solution
		// Take two Stack
		// S1 -> S2 then x -> S1 then S2 -> S1
		// T.C = O(n), S.C = O(2n)

		/***
		 * MyQueue q = new MyQueue(); q.push(3); q.push(4); System.out.println("The
		 * element poped is " + q.pop()); q.push(5); System.out.println("The top element
		 * is " + q.peek()); System.out.println("The size of the queue is " + q.size());
		 ***/

		// T.C = O(1) amortized
		// S.C = O(2n)
		MyQueue1 q = new MyQueue1();
		q.push(3);
		q.push(4);
		System.out.println("The element poped is " + q.pop());
		q.push(5);
		System.out.println("The top element is " + q.peek());
		System.out.println("The size of the queue is " + q.size());
	}

}
