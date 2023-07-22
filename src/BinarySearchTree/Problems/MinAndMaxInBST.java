package BinarySearchTree.Problems;

class MinMaxNode {

	int val;
	MinMaxNode left, right;

	public MinMaxNode() {

	}

	public MinMaxNode(int key) {

		this.val = key;

	}
}

public class MinAndMaxInBST {

	private static int findMax(MinMaxNode root) {

		if (root == null)
			return Integer.MIN_VALUE;

		int res = root.val;
		int rres = findMax(root.right);
		int lres = findMax(root.left);

		if (lres > res)
			res = lres;

		if (rres > res)
			res = rres;

		return res;

	}

	private static int findMin(MinMaxNode root) {

		if (root == null)
			return Integer.MAX_VALUE;

		int res = root.val;
		int lres = findMin(root.left);
		int rres = findMin(root.right);

		if (lres < res)
			res = lres;
		if (rres < res)
			res = rres;
		return res;
	}

	public static void main(String[] args) {

		MinMaxNode root = new MinMaxNode(5);
		root.left = new MinMaxNode(2);
		root.right = new MinMaxNode(8);
		root.left.left = new MinMaxNode(1);
		root.left.right = new MinMaxNode(3);
		root.right.right = new MinMaxNode(9);
		root.right.left = new MinMaxNode(6);

		System.out.println(findMin(root));

		System.out.println(findMax(root));

	}
}
