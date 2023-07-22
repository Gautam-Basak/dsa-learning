package BinaryTree.Medium;

class SymmetricNode {

	int val;
	SymmetricNode left, right;

	public SymmetricNode() {

	}

	public SymmetricNode(int key) {

		this.val = key;

	}
}

public class CheckBTIsSymmetricOrNot {

	public static void main(String[] args) {

		SymmetricNode root = new SymmetricNode(1);
		root.left = new SymmetricNode(2);
		root.right = new SymmetricNode(2);
		root.left.right = new SymmetricNode(3);
		root.right.right = new SymmetricNode(3);

		if (isSymmetrical(root))
			System.out.println("Yes BT is Symmetric");
		else
			System.out.println("Yes BT is not Symmetric");

	}

	private static boolean isSymmetrical(SymmetricNode root) {

		if (root == null)
			return true;

		return isSymmetrical(root.left, root.right);

	}

	private static boolean isSymmetrical(SymmetricNode root1, SymmetricNode root2) {

		if (root1 == null && root2 == null)
			return true;

		else if (root1 == null || root2 == null)
			return false;

		return ((root1.val == root2.val) && isSymmetrical(root1.left, root2.right)
				&& isSymmetrical(root1.right, root2.left));
	}

}
