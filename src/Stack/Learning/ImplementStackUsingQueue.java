package Stack.Learning;

import java.util.LinkedList;
import java.util.Queue;

class StackQueue {

	Queue<Integer> q = new LinkedList<>();

	void push(int x) {

		q.add(x);
		for (int i = 0; i < q.size() - 1; i++) {
			q.add(q.remove());
		}
	}

	int peek() {
		return q.peek();
	}

	int pop() {
		return q.remove();
	}

	int size() {
		return q.size();
	}
}

public class ImplementStackUsingQueue {

	public static void main(String[] args) {
		
		StackQueue sq = new StackQueue();
		
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);

		System.out.println("Top of the stack: " + sq.peek());
        System.out.println("Size of the stack before removing element: " + sq.size());
        System.out.println("The deleted element is: " + sq.pop());
        System.out.println("Top of the stack after removing element: " + sq.peek());
        System.out.println("Size of the stack after removing element: " + sq.size());
	}

}
