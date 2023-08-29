package BinarySearchTree.Problems;

class SuccessorNode {

	int val;
	SuccessorNode left, right;

	public SuccessorNode() {

	}

	public SuccessorNode(int key) {

		this.val = key;

	}
}

public class InOrderSuccessorOfBST {

	public static void main(String[] args) {

		SuccessorNode root = new SuccessorNode(5);
		root.left = new SuccessorNode(2);
		root.right = new SuccessorNode(8);
		root.left.left = new SuccessorNode(1);
		root.left.right = new SuccessorNode(3);
		root.right.right = new SuccessorNode(9);
		root.right.left = new SuccessorNode(6);

		// Successor means next value.
		// InOrder successor means next greater value because in InOrder the elements
		// are sorted in increasing order.

		// Naive Solution = InOrder iterate over the tree, collect all the elements in
		// List, then run a loop and find the successor of a give value.
		// T.C = O(N) + O(nLogn or N) -> 1st O(N) is for traversal through all elements
		// then O(nLogn) for finding the successor if we use Binary Search or 2nd O(N)
		// if we use Linear Search
		// S.C = O(N) for storing the elements

		// Better Solution = InOrder Iterate over the tree and the first element greater
		// than the given element is the successor.
		// T.C = O(N), S.C = O(N) Auxiliary Stack Space if we use recursion or O(1) for
		// Moris Traversal.

		// Optimized Solution = As we know for BST best T.C is Height of the Tree, so we
		// will keep a successor element and then we will compare the given element with
		// the root and move on the right or left after that we will go left right <->
		// left right till the reach the leaf node and keep updating the successor.
		// T.C = O(H), Height of the Tree
		// S.C = O(1)

		int val = 8;

		SuccessorNode ans = findSuccessor(root, val);
		System.out.println(ans.val);
	}

	private static SuccessorNode findSuccessor(SuccessorNode root, int val) {

		SuccessorNode successor = null;

		while (root != null) {

			if (val >= root.val) {
				root = root.right;
			} else {
				successor = root;
				root = root.left;
			}

		}
		return successor;
	}

}
