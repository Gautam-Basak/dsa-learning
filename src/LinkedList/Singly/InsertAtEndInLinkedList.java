package LinkedList.Singly;

class Node {

	int value;
	Node next;

	Node(int x) {
		value = x;
		next = null;
	}
}

public class InsertAtEndInLinkedList {

	private static Node insertAtEnd(int value, Node head) {

		Node temp = new Node(value);
		
		if(head == null)
			return temp;
		
		Node curr = head;
		while(curr.next != null) {
			curr=curr.next;
		}
		
		curr.next = temp;
		return head;
	}

	public static void main(String[] args) {

		Node head = null;
		head = insertAtEnd(40, head);
		head = insertAtEnd(30, head);
		head = insertAtEnd(20, head);
		System.out.println("Before Inserting at End");
		printList(head);
		head = insertAtEnd(10, head);
		
		System.out.println("After Inserting at End");
		printList(head);
		
	}

	private static void printList(Node head) {
		
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.value + " ");
			curr = curr.next;
		}
		System.out.println();
	}

}
