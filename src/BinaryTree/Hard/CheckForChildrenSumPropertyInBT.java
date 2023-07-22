package BinaryTree.Hard;

class ChildrenSumNode {
	int data;
	ChildrenSumNode left, right;

	ChildrenSumNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

public class CheckForChildrenSumPropertyInBT {

	public static void main(String[] args) {

		// Write a program that converts any binary tree to one that follows the
		// children sum property.

		// The children sum property is defined as, For every node of the tree, the
		// value of a node is equal to the sum of values of its children(left child and
		// right child).

		ChildrenSumNode root = new ChildrenSumNode(2);
		root.left = new ChildrenSumNode(35);
		root.left.left = new ChildrenSumNode(2);
		root.left.right = new ChildrenSumNode(3);
		root.right = new ChildrenSumNode(10);
		root.right.left = new ChildrenSumNode(5);
		root.right.right = new ChildrenSumNode(2);

		changeTree(root);
		System.out.println(root.data);
	}

	private static void changeTree(ChildrenSumNode root) {

		if (root == null)
			return;

		int child = 0;

		if (root.left != null)
			child += root.left.data;

		if (root.right != null)
			child += root.right.data;

		if (root.data < child)
			root.data = child;
		else {
			if (root.left != null)
				root.left.data = root.data;
			else if (root.right != null)
				root.right.data = root.data;
		}
		
		changeTree(root.left);
		changeTree(root.right);
		
		int tot = 0;
		if(root.left != null)
			tot += root.left.data;
		if(root.right != null)
			tot += root.right.data;
		if(root.left != null || root.right != null)
			root.data = tot;
	}

}
