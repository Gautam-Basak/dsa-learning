package BinaryTree.Medium;

import java.util.ArrayList;

class BoundaryNode {

	int val;
	BoundaryNode left, right;

	public BoundaryNode() {

	}

	public BoundaryNode(int key) {

		this.val = key;

	}
}

public class BoundaryTraversalOfBT {

	private static boolean isLeaf(BoundaryNode root) {

		return (root.left == null) && (root.right == null);
	}

	private static void addLeftBoundary(BoundaryNode root, ArrayList<Integer> ans) {

		BoundaryNode curr = root.left;

		while (curr != null) {

			if (isLeaf(curr) == false) {
				ans.add(curr.val);
			}
			if (curr.left != null) {
				curr = curr.left;
			} else
				curr = curr.right;
		}
	}

	private static void addLeaves(BoundaryNode root, ArrayList<Integer> ans) {

		if (isLeaf(root)) {
			ans.add(root.val);
			return;
		}

		if (root.left != null)
			addLeaves(root.left, ans);
		if (root.right != null)
			addLeaves(root.right, ans);
	}

	private static void addRightBoundary(BoundaryNode root, ArrayList<Integer> ans) {

		BoundaryNode curr = root.right;
		ArrayList<Integer> temp = new ArrayList<>();

		while (curr != null) {

			if (isLeaf(curr) == false) {
				temp.add(curr.val);
			}
			if (curr.right != null) {
				curr = curr.right;
			} else
				curr = curr.left;
		}

		for (int i = temp.size() - 1; i >= 0; i--) {
			ans.add(temp.get(i));
		}
	}

	private static ArrayList<Integer> printBoundary(BoundaryNode node) {

		ArrayList<Integer> ans = new ArrayList<>();

		// Check if the node is Leaf Node or not, it not add it in the Queue
		// If the First node itself is Leaf Node, then addLeaves method will run and
		// will add it in the Queue
		if (isLeaf(node) == false)
			ans.add(node.val);

		// The entire program run on Pre-Order Traversal

		// Every node will be checked if the node is not Leaf, it will be added in the
		// Queue
		// The first node of every sub tree, is nothing but root, we will check if not
		// Leaf we will add it in the queue
		// The first step of Pre-Order is done
		addLeftBoundary(node, ans);

		// All the Leaf Nodes from Left to Right are added, which completes the second
		// steps of Pre-Order of sub tree
		addLeaves(node, ans);

		// When return everything from left side, right side will be executed which
		// completes the third steps of Pre-Order
		addRightBoundary(node, ans);

		return ans;
	}

	public static void main(String[] args) {

		BoundaryNode root = new BoundaryNode(1);
		root.left = new BoundaryNode(2);
		root.left.right = new BoundaryNode(12);
		root.left.left = new BoundaryNode(3);
		root.left.left.right = new BoundaryNode(4);
		root.left.left.right.left = new BoundaryNode(5);
		root.left.left.right.right = new BoundaryNode(6);
		root.right = new BoundaryNode(7);
		root.right.right = new BoundaryNode(8);
		root.right.right.left = new BoundaryNode(9);
		root.right.right.left.left = new BoundaryNode(10);
		root.right.right.left.right = new BoundaryNode(11);

		ArrayList<Integer> boundaryTraversal;

		boundaryTraversal = printBoundary(root);

		System.out.println("The Boundary Traversal is : ");
		for (int i = 0; i < boundaryTraversal.size(); i++) {
			System.out.print(boundaryTraversal.get(i) + " ");
		}
	}
}
