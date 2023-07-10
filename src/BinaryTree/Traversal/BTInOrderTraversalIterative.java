package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.Stack;

class InNode {
	int data;
	InNode left, right;

	InNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	InNode() {

	}
}

public class BTInOrderTraversalIterative {

	private static ArrayList<Integer> inOrderTravIterative(InNode curr) {

		ArrayList<Integer> inOrder = new ArrayList<>();

		if (curr == null)
			return inOrder;

		Stack<InNode> s = new Stack<>();

		while (true) {

			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {
				if (s.isEmpty())
					break;

				curr = s.peek();

				inOrder.add(curr.data);
				s.pop();

				curr = curr.right;
			}
		}
		return inOrder;
	}

	public static void main(String[] args) {

		InNode root = new InNode(1);
		root.left = new InNode(2);
		root.right = new InNode(3);
		root.left.left = new InNode(4);
		root.left.right = new InNode(5);
		root.left.right.left = new InNode(8);
		root.right.left = new InNode(6);
		root.right.right = new InNode(7);
		root.right.right.left = new InNode(9);
		root.right.right.right = new InNode(10);

		ArrayList<Integer> inOrder = inOrderTravIterative(root);
		System.out.print(inOrder);

	}

}
