package LinkedList.Singly;

class Node {

	int value;
	Node next;

	Node(int x) {
		value = x;
		next = null;
	}
}

public class TraversingThroughLinkedList {

	public static void main(String[] args) {

		Node head = new Node(10);
		Node temp = new Node(20);
		Node temp1 = new Node(30);

		head.next = temp;
		temp.next = temp1;

		printList(head);

	}

	private static void printList(Node head) {

		Node curr = head;
		while (curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}

	}

}
