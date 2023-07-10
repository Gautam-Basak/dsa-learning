package BinaryTree.Traversal;

class PostOrderNode {
	int data;
	PostOrderNode left, right;

	PostOrderNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	PostOrderNode() {

	}
}

public class BTPostOrderTraversalRecursion {

	private static void postOrderTrav(PostOrderNode curr) {

		if (curr == null)
			return;

		postOrderTrav(curr.left);
		postOrderTrav(curr.right);
		System.out.print(curr.data);

	}

	public static void main(String[] args) {

		PostOrderNode root = new PostOrderNode(1);
		root.left = new PostOrderNode(2);
		root.right = new PostOrderNode(3);
		root.left.left = new PostOrderNode(4);
		root.left.right = new PostOrderNode(5);
		root.left.right.left = new PostOrderNode(8);
		root.right.left = new PostOrderNode(6);
		root.right.right = new PostOrderNode(7);
		root.right.right.left = new PostOrderNode(9);
		root.right.right.right = new PostOrderNode(10);

		postOrderTrav(root);

	}

}
