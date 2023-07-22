package BinarySearchTree.Problems;

class DeleteNode {

	int val;
	DeleteNode left, right;

	public DeleteNode() {

	}

	public DeleteNode(int key) {

		this.val = key;

	}
}

public class DeleteANodeInBST {

	private static DeleteNode deleteNode(DeleteNode root, int key) {

		if (root == null)
			return null;

		if (root.val == key)
			return helper(root);

		// If root is not equal to key, then at the end we have to return the original
		// root.
		// So we keep a copy as dummy of the original root node.
		DeleteNode dummy = root;
		while (root != null) {

			if (key < root.val) {
				if (root.left != null && root.left.val == key) {
					root.left = helper(root.left);
					break;
				} else {
					root = root.left;
				}

			} else {
				if (root.right != null && root.right.val == key) {
					root.right = helper(root.left);
					break;
				} else {
					root = root.right;
				}
			}
		}
		return dummy;
	}

	private static DeleteNode helper(DeleteNode root) {

		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {
			DeleteNode rightChild = root.right;
			DeleteNode lastRight = findLastRight(root.left);
			lastRight.right = rightChild;

			return root.left;
		}

	}

	private static DeleteNode findLastRight(DeleteNode root) {

		if (root.right == null)
			return root;

		return findLastRight(root.right);
	}

	public static void main(String[] args) {

		DeleteNode root = new DeleteNode(5);
		root.left = new DeleteNode(2);
		root.right = new DeleteNode(8);
		root.left.left = new DeleteNode(1);
		root.left.right = new DeleteNode(3);
		root.right.right = new DeleteNode(9);
		root.right.left = new DeleteNode(6);

		int key = 3;

		// Helper class will check first root.left or root.right is null or not if
		// anyone is null at the same time we will return the other one.

		// If above two is not true then comes the third condition.
		// 1st we will keep track of root.right as rightChild
		// 2nd we the find the root.left's right most node and keep it as lastRight and
		// then we will assign lastRight.right as rightChild, then it will become a BST

		// At the end root.left(which means root.left.left as in helper function we pass
		// root.left and the function return root.left so all together root.left.left)
		// will be return which in turn join to the original root.

		DeleteNode ansRoot = deleteNode(root, key);
		System.out.println(ansRoot.val);

	}

}
