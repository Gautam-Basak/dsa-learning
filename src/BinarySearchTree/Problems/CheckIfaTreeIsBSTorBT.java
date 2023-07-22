package BinarySearchTree.Problems;

class BSTorBTNode {
	int data;
	BSTorBTNode left, right;

	BSTorBTNode(int val) {
		data = val;
		left = null;
		right = null;
	}
}

public class CheckIfaTreeIsBSTorBT {

	public static void main(String[] args) {

		BSTorBTNode root = new BSTorBTNode(5);
		root.left = new BSTorBTNode(2);
		root.right = new BSTorBTNode(8);
		root.left.left = new BSTorBTNode(1);
		root.left.right = new BSTorBTNode(3);
		root.right.right = new BSTorBTNode(9);
		root.right.left = new BSTorBTNode(6);

		int minValue = Integer.MIN_VALUE;
		int maxValue = Integer.MAX_VALUE;

		if (isValidBST(root, minValue, maxValue))
			System.out.println("Yes the BT is BST");
		else
			System.out.println("Yes the BT is BST");

	}

	private static boolean isValidBST(BSTorBTNode root, int minValue, int maxValue) {

		if (root == null)
			return true;

		if (root.data <= minValue || root.data >= maxValue)
			return false;

		return isValidBST(root.left, minValue, root.data) && isValidBST(root.right, root.data, minValue);

	}
}
