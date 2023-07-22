package BinarySearchTree.Problems;

class InsertNode {

	int val;
	InsertNode left, right;

	public InsertNode() {

	}

	public InsertNode(int key) {

		this.val = key;

	}
}

public class InsertANodeInBST {

	public static void main(String[] args) {

		// Insert a Node anywhere but make it maintains both right BST and left BST.
		// Best position to insert a Node at "Leaf"

		// Also the question asked is Insert a Node and Return the "root"

		InsertNode root = new InsertNode(5);
		root.left = new InsertNode(2);
		root.right = new InsertNode(8);
		root.left.left = new InsertNode(1);
		root.left.right = new InsertNode(3);
		root.right.right = new InsertNode(9);
		root.right.left = new InsertNode(6);

		int val = 4;

		System.out.println(insertNode(root, val));

	}

	private static InsertNode insertNode(InsertNode root, int val) {

		if (root == null)
			return new InsertNode(val);

		// You need to create a copy of the root because at the end you have to return
		// the root.
		// And if you don't create a copy and use the root for iteration then just think
		// after traversing the whole tree with root you will reach leaf, then you will
		// add the "val" and at that point the root is not the original root of the
		// tree.

		InsertNode curr = root;

		while (true) {
			if (val > curr.val) {
				if (curr.right != null) {
					curr = curr.right;
				} else {
					curr.right = new InsertNode(val);
					break;
				}
			} else {
				if (curr.left != null) {
					curr = curr.left;
				} else {
					curr.left = new InsertNode(val);
					break;
				}
			}
		}
		return root;
	}

}
