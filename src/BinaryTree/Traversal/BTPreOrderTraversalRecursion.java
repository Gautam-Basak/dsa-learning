package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class PreOrderNode {
	int data;
	PreOrderNode left, right;

	PreOrderNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	PreOrderNode() {

	}
}

public class BTPreOrderTraversalRecursion {

	// Recursive Solution
	private static void preOrderTravRecursive(PreOrderNode curr) {

		if (curr == null)
			return;

		System.out.print(curr.data + " ");
		preOrderTravRecursive(curr.left);
		preOrderTravRecursive(curr.right);

	}

	public static void main(String[] args) {

		PreOrderNode root = new PreOrderNode(1);
		root.left = new PreOrderNode(2);
		root.right = new PreOrderNode(3);
		root.left.left = new PreOrderNode(4);
		root.left.right = new PreOrderNode(5);
		root.left.right.left = new PreOrderNode(8);
		root.right.left = new PreOrderNode(6);
		root.right.right = new PreOrderNode(7);
		root.right.right.left = new PreOrderNode(9);
		root.right.right.right = new PreOrderNode(10);

		System.out.print("\n");

		preOrderTravRecursive(root);

	}

}
