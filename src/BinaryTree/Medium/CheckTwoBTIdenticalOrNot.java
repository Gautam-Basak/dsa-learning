package BinaryTree.Medium;

class IdenticalNode {

	int val;
	IdenticalNode left, right;

	public IdenticalNode() {

	}

	public IdenticalNode(int key) {

		this.val = key;

	}
}

public class CheckTwoBTIdenticalOrNot {

	public static void main(String[] args) {

		IdenticalNode root1 = new IdenticalNode(1);
		root1.left = new IdenticalNode(2);
		root1.right = new IdenticalNode(3);
		root1.right.left = new IdenticalNode(4);
		root1.right.right = new IdenticalNode(5);

		IdenticalNode root2 = new IdenticalNode(1);
		root2.left = new IdenticalNode(2);
		root2.right = new IdenticalNode(3);
		root2.right.left = new IdenticalNode(4);

		if (isIdentical(root1, root2))
			System.out.println("BT are Identical");
		else
			System.out.println("BT are not Identical");

	}

	private static boolean isIdentical(IdenticalNode root1, IdenticalNode root2) {

		if (root1 == null && root2 == null)
			return true;

		else if (root1 == null || root2 == null)
			return false;

		return ((root1.val == root2.val) && isIdentical(root1.left, root2.left)
				&& isIdentical(root1.right, root2.right));

	}

}
