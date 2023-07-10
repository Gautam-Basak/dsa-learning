package BinaryTree.Medium;

class MaxNode {

	int val;
	MaxNode left, right;

	public MaxNode() {

	}

	public MaxNode(int key) {

		this.val = key;

	}
}

public class MaximumInBT {

	private static int maxInBT(MaxNode root) {

		if (root == null) {
			return Integer.MIN_VALUE;
		}

		return Math.max(root.val, Math.max(maxInBT(root.left), maxInBT(root.right)));
	}

	public static void main(String[] args) {

		MaxNode root = new MaxNode(100);
		root.left = new MaxNode(2);
		root.right = new MaxNode(3);
		root.right.right = new MaxNode(4);
		root.right.right.right = new MaxNode(112);

		System.out.println(maxInBT(root));

	}
}