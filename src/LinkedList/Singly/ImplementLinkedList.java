package LinkedList.Singly;

class Node {

	int value;
	Node next;

	Node(int x) {
		value = x;
		next = null;
	}
}

public class ImplementLinkedList {

	public static void main(String[] args) {

		Node head = new Node(10);
		Node temp = new Node(20);
		Node temp1 = new Node(30);

		head.next = temp;
		temp.next = temp1;

		System.out.println(head.value + "-->" + temp.value + "-->" + temp1.value);
		System.out.println(head.next);
		System.out.println(temp.next);
		System.out.println(temp1.next);

	}
}
