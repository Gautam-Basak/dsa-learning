package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.Stack;

class PostNode {
	int data;
	PostNode left, right;

	PostNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	PostNode() {

	}
}

public class BTPostOrderTraversalIterative {

	private static ArrayList<Integer> inOrderTravIterative(PostNode curr) {

		ArrayList<Integer> postOrder = new ArrayList<>();

		if (curr == null)
			return postOrder;

		Stack<PostNode> s = new Stack<>();

		while (!s.isEmpty() || curr != null) {

			if (curr != null) {
				s.push(curr);
				curr = curr.left;
			} else {

				PostNode temp = s.peek().right;

				if (temp == null) {

					temp = s.peek();
					postOrder.add(temp.data);
					s.pop();
					while (!s.isEmpty() && temp == s.peek().right) {
						temp = s.peek();
						postOrder.add(temp.data);
						s.pop();
					}

				} else {
					curr = temp;
				}
			}
		}
		return postOrder;
	}

	public static void main(String[] args) {

		PostNode root = new PostNode(1);
		root.left = new PostNode(2);
		root.right = new PostNode(3);
		root.left.left = new PostNode(4);
		root.left.right = new PostNode(5);
		root.left.right.left = new PostNode(8);
		root.right.left = new PostNode(6);
		root.right.right = new PostNode(7);
		root.right.right.left = new PostNode(9);
		root.right.right.right = new PostNode(10);

		ArrayList<Integer> postOrder = inOrderTravIterative(root);
		System.out.print(postOrder);

	}
}
