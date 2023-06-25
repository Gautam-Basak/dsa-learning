package LinkedList.Singly;

class Node {

	int value;
	Node next;

	Node(int x) {
		value = x;
		next = null;
	}
}

public class DeleteANodeAtBeginningInLinkedList {

	// For Deleting
	private static Node deleteFirstNode(Node head) {

		if (head == null)
			return null;
		else {
			return head.next;
		}

	}

	// For Printing
	private static void printList(Node head) {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}

	// For Inserting
	private static Node insertNode(int value, Node head) {

		Node temp = new Node(value);

		temp.next = head;

		return temp;
	}

	public static void main(String[] args) {

		Node head = null;
		head = insertNode(40, head);
		head = insertNode(30, head);
		head = insertNode(20, head);
		head = insertNode(10, head);
		printList(head);

		head = deleteFirstNode(head);

		printList(head);
	}

}
