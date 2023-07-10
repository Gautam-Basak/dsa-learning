package BinaryTree.Medium;

class MaxSumNode {

	int val;
	MaxSumNode left, right;

	public MaxSumNode() {

	}

	public MaxSumNode(int key) {

		this.val = key;

	}
}

public class MaximumPathSum {

	public static void main(String[] args) {

		MaxSumNode root = new MaxSumNode(100);
		root.left = new MaxSumNode(120);
		root.left.left = new MaxSumNode(200);
		root.left.right = new MaxSumNode(2);
		root.right = new MaxSumNode(30);
		root.right.right = new MaxSumNode(60);
		root.right.right.right = new MaxSumNode(70);
		root.right.left = new MaxSumNode(10);
		root.right.left.left = new MaxSumNode(20);

		// This solution is done taking global variable. And global variable should be
		// avoided.
		// We will try to solve avoiding global variable
		maxPathSum(root);
		System.out.println("Diameter of BT " + maxSum);

	}

	static int maxSum = 0;

	private static int maxPathSum(MaxSumNode root) {

		if (root == null)
			return 0;

		// We are comparing with '0' because if we encounter negative value on left side
		// or right side we will never get Maximum value so to avoid that
		// we will return '0', as Max of (0, -ve value) is always zero.
		int left = Math.max(0, maxPathSum(root.left));
		int right = Math.max(0, maxPathSum(root.right));

		maxSum = Math.max(maxSum, left + right + root.val);

		return Math.max(left, right) + root.val;
	}

}
