package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.Stack;

class PreNode {
	int data;
	PreNode left, right;

	PreNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	PreNode() {

	}
}

public class BTPreOrderTraversalIterative {

	// Iterative Solution
	private static ArrayList<Integer> preOrderTravIterative(PreNode curr) {

		ArrayList<Integer> preOrder = new ArrayList<>();

		if (curr == null)
			return preOrder;

		Stack<PreNode> s = new Stack<>();
		s.push(curr);

		// In pre-order -> Root Left Right is followed.
		// But as we use stack, we first add root and at the same time we pop "root",
		// then we add right then left so that left can pop first and then
		// right, which in turn follow the patter.

		while (!s.isEmpty()) {

			PreNode topNode = s.peek();

			preOrder.add(topNode.data);
			s.pop();

			if (topNode.right != null) {
				s.push(topNode.right);
			}

			if (topNode.left != null) {
				s.push(topNode.left);
			}
		}
		return preOrder;
	}

	public static void main(String[] args) {

		PreNode root = new PreNode(1);
		root.left = new PreNode(2);
		root.right = new PreNode(3);
		root.left.left = new PreNode(4);
		root.left.right = new PreNode(5);
		root.left.right.left = new PreNode(8);
		root.right.left = new PreNode(6);
		root.right.right = new PreNode(7);
		root.right.right.left = new PreNode(9);
		root.right.right.right = new PreNode(10);

		ArrayList<Integer> preOrder = preOrderTravIterative(root);
		System.out.print(preOrder);

	}
}
