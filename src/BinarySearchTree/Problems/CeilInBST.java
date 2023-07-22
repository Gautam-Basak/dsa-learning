package BinarySearchTree.Problems;

class CeilNode {

	int val;
	CeilNode left, right;

	public CeilNode() {

	}

	public CeilNode(int key) {

		this.val = key;

	}
}

public class CeilInBST {

	public static void main(String[] args) {

		CeilNode root = new CeilNode(5);
		root.left = new CeilNode(2);
		root.right = new CeilNode(8);
		root.left.left = new CeilNode(1);
		root.left.right = new CeilNode(3);
		root.right.right = new CeilNode(9);
		root.right.left = new CeilNode(6);

		int key = 9;

		System.out.println(findCeil(root, key));

	}

	private static int findCeil(CeilNode root, int key) {

		int ceil = -1;

		while (root != null) {

			if (root.val == key) {
				ceil = root.val;
				return ceil;
			}

			if (key > root.val) {
				root = root.right;
			} else {
				ceil = root.val;
				root = root.left;
			}
		}

		return ceil;

	}

}
