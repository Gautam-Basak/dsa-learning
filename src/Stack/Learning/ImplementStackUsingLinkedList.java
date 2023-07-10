package Stack.Learning;

class MyStackLinkedList {

	class StackNode {

		int value;
		StackNode next;

		public StackNode(int x) {

			this.value = x;
			this.next = null;

		}
	}

	StackNode top;
	int size;

	MyStackLinkedList() {
		this.top = null;
		this.size = 0;
	}

	void printStack() {

		StackNode curr = top;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();

	}

	void stackPush(int x) {

		StackNode newNode = new StackNode(x);

		newNode.next = top;
		top = newNode;
		System.out.println("Element pushed");
		size++;
	}

	int stackPeep() {

		if (top == null)
			return -1;

		return top.value;
	}

	int stackPop() {

		if (top == null)
			return -1;

		int topData = top.value;

		top = top.next;
		return topData;
	}

	public int stackSize() {
		return size;
	}

	public boolean stackIsEmpty() {
		return top == null;
	}
}

public class ImplementStackUsingLinkedList {

	public static void main(String[] args) {

		MyStackLinkedList s = new MyStackLinkedList();
		s.stackPush(10);
		s.stackPush(20);
		s.printStack();
		System.out.println(s.stackPeep());
		System.out.println("Element popped " + s.stackPop());
		System.out.println("Stack size: " + s.stackSize());
		System.out.println("Stack is empty or not: " + s.stackIsEmpty());
		System.out.println(s.stackPeep());

	}

}
