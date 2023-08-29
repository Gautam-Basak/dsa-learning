package BinarySearchTree.Problems;

class PredecessorNode {

	int val;
	PredecessorNode left, right;

	public PredecessorNode() {

	}

	public PredecessorNode(int key) {

		this.val = key;

	}
}

public class InOrderPredecessorOfBST {

	public static void main(String[] args) {

		PredecessorNode root = new PredecessorNode(5);
		root.left = new PredecessorNode(2);
		root.right = new PredecessorNode(8);
		root.left.left = new PredecessorNode(1);
		root.left.right = new PredecessorNode(3);
		root.right.right = new PredecessorNode(9);
		root.right.left = new PredecessorNode(6);

		// Predecessor means previous value.
		// InOrder Predecessor means previous small value because in InOrder the
		// elements are sorted in increasing order.

		// We will use a trick here, we will use reverse InOrder then all the elements
		// will be collected in decreasing order
		// Then we will simply find the next vale of the given element, which will give
		// the predecessor

		int val = 2;

		PredecessorNode ans = findPredecessor(root, val);
		System.out.println(ans.val);
	}

	private static PredecessorNode findPredecessor(PredecessorNode root, int val) {

		PredecessorNode predecessor = null;

		while (root != null) {

			if (val <= root.val) {
				root = root.left;
			} else {
				predecessor = root;
				root = root.right;
			}

		}
		return predecessor;
	}

}
