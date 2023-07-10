package BinaryTree.Traversal;

class InOrderNode {
	int data;
	InOrderNode left, right;

	InOrderNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	InOrderNode() {

	}
}

public class BTInOrderTraversalRecursion {

	private static void inOrderTrav(InOrderNode curr) {

		if (curr == null)
			return;

		inOrderTrav(curr.left);
		System.out.print(curr.data);
		inOrderTrav(curr.right);

	}

	public static void main(String[] args) {

		InOrderNode root = new InOrderNode(1);
		root.left = new InOrderNode(2);
		root.right = new InOrderNode(3);
		root.left.left = new InOrderNode(4);
		root.left.right = new InOrderNode(5);
		root.left.right.left = new InOrderNode(8);
		root.right.left = new InOrderNode(6);
		root.right.right = new InOrderNode(7);
		root.right.right.left = new InOrderNode(9);
		root.right.right.right = new InOrderNode(10);

		inOrderTrav(root);

	}

}
