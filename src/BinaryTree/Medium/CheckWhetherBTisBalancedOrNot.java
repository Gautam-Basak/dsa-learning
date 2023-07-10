package BinaryTree.Medium;

class BalanceNode {

	int val;
	BalanceNode left, right;

	public BalanceNode() {

	}

	public BalanceNode(int key) {

		this.val = key;

	}
}

public class CheckWhetherBTisBalancedOrNot {

	private static int dfsHeight(BalanceNode root) {

		if (root == null)
			return 0;

		int lh = dfsHeight(root.left);
		if (lh == -1)
			return -1;

		int rh = dfsHeight(root.right);
		if (rh == -1)
			return -1;

		if (Math.abs(lh - rh) > 1)
			return -1;

		int x = 1 + Math.max(lh, rh);

		return x;

	}

	private static void isBalanced(BalanceNode root) {

		int ans = dfsHeight(root);

		if (ans == -1)
			System.out.println("BT is not balanced");

		else
			System.out.println("BT is balanced");
	}

	public static void main(String[] args) {

		BalanceNode root = new BalanceNode(1);
		root.left = new BalanceNode(2);
		root.right = new BalanceNode(3);
		root.right.right = new BalanceNode(4);
		root.right.right.right = new BalanceNode(9);

		// If it returns -1, that means not Balanced.
		// If it return any positive number, that it passes all the above if conditions
		// and the BT will be considered as Balanced
		isBalanced(root);

	}

}
