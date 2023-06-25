package LinkedList.Singly;

class Node {

	int value;
	Node next;

	Node(int x) {
		value = x;
		next = null;
	}
}

public class InsertAtBeginningInLinkedList {

	private static void printList(Node head) {

		Node curr = head;
		for (; curr != null; curr = curr.next) {
			System.out.print(curr.value + "-->");
		}
		System.out.println("null");
	}

	static Node insertAtFirst(int value, Node head) {

		Node newNode = new Node(value);

		newNode.next = head;

		head = newNode;

		return head;

	}

	public static void main(String[] args) {

		Node head = null;
		head = insertAtFirst(40, head);
		head = insertAtFirst(30, head);
		head = insertAtFirst(20, head);
		head = insertAtFirst(10, head);
		System.out.println("Before Inserting at Beginning");
		printList(head);

		head = insertAtFirst(5, head);
		System.out.println("After Inserting at Beginning");
		printList(head);
	}

}
