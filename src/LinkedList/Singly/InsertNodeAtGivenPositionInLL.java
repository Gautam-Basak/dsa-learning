package LinkedList.Singly;

class Node {

	int value;
	Node next;

	Node(int x) {
		value = x;
		next = null;
	}
}

public class InsertNodeAtGivenPositionInLL {

	// Insert the Nodes at the end.
	static Node insertInList(int value, Node head) {

		Node temp = new Node(value);

		if (head == null)
			return temp;

		Node curr = head;

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = temp;
		return head;
	}

	// Printing the Nodes
	static void printList(Node head) {

		Node curr = head;
		while (curr != null) {

			System.out.print(curr.value + "-->");

			curr = curr.next;
		}
		System.out.println("null");

	}

	static Node insertNodeAtGivenPos(int value, int pos, Node head) {

		Node temp = new Node(value);

		if (pos == 1) {
			temp.next = head;
			return temp;
		}

		Node curr = head;
		for (int i = 1; i < pos - 1; i++) {

			curr = curr.next;
			if (curr == null) {
                System.out.println("Position out of range");
                return head;
            }
		}

		temp.next = curr.next;
		curr.next = temp;

		return head;
	}

	public static void main(String[] args) {
		
		int pos = 2;
		
		Node head = null;
		head = insertInList(10, head);
		head = insertInList(20, head);
		head = insertInList(30, head);
		

		printList(head);
		
		head = insertNodeAtGivenPos(45, pos, head);
		printList(head);
		
	}

}
