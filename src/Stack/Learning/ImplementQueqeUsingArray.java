package Stack.Learning;

class Queue {

	private int arr[];
	private int front, rear, currSize, maxSize;

	public Queue(int maxSize) {

		this.maxSize = maxSize;
		arr = new int[16];
		front = -1;
		rear = -1;
		currSize = 0;
	}

	void push(int x) {

		if (currSize == maxSize) {

			System.out.println("Queue is full");
			System.exit(1);
		}

		if (rear == -1) {
			front = 0;
			rear = 0;
		} else {
			rear = (rear + 1) % maxSize;
		}

		arr[rear] = x;
		System.out.println("The element pushed is " + x);
		currSize++;
	}

	int peek() {

		if (front == -1) {
			System.out.println("Queue is empty");
			System.exit(1);
		}

		return arr[front];
	}

	int pop() {

		if (front == -1) {
			System.out.println("Queue is empty");

		}

		int popped = arr[front];

		if (currSize == 1) {
			front = -1;
			rear = -1;
		} else {
			front = (front + 1) % maxSize;
		}

		currSize--;

		return popped;
	}

	int size() {
		return currSize;
	}

}

public class ImplementQueqeUsingArray {

	public static void main(String[] args) {

		Queue q = new Queue(6);
		q.push(4);
		q.push(14);
		q.push(24);
		q.push(34);
		System.out.println("The peek of the queue before deleting any element " + q.peek());
		System.out.println("The size of the queue before deletion " + q.size());
		System.out.println("The first element to be deleted " + q.pop());
		System.out.println("The peek of the queue after deleting an element " + q.peek());
		System.out.println("The size of the queue after deleting an element " + q.size());

	}

}
