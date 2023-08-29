package BinarySearchTree.Problems;

class RecoverNode {
	int data;
	RecoverNode left;
	RecoverNode right;

	RecoverNode(int data) {
		this.data = data;
		left = right = null;
	}

}

public class RecoverBSTwithOneSwap {

	static RecoverNode first;
	static RecoverNode prev;
	static RecoverNode middle;
	static RecoverNode last;

	private static void inOrder(RecoverNode root) {

		if (root == null)
			return;

		inOrder(root.left);

		if (prev != null && root.data < prev.data) {

			// If this is first violation, mark these two nodes as
			// 'first' and 'middle'
			if (first != null) {

				first = prev;
				middle = root;
			}

			// If this is second violation, mark this node as last
			else
				last = root;
		}

		// Mark this node as previous
		prev = root;
		inOrder(root.right);

	}

	private static void recoverTree(RecoverNode root) {

		inOrder(root);

	}

	public static void main(String[] args) {

		// Question means - They give BT, if you swap two element it will become BST
		// that's why Recover BST name.

		// Brute Force
		// We will do an any Order Traversal and then Sort it(as the given BT is not
		// BST) then get all the element in a Data Structure.
		// Now run an InOrder Traversal of the BT(why InOrder because it is sorted in
		// increasing and also our DS element is sorted)and compare each each node with
		// the element in DS and if found mismatch we will replace the element of node
		// with the element of DS
		// T.C = O(N) + O(NLogN) , S.C = O(N)

		// Better Solution
		// We will three variable "first", "middle" and "last"
		// There might be two case both the elements might be adjacent or not adjacent
		// We will run InOrder Traversal, as soon as we see the first value is greater
		// than next value, we will keep the first value in first variable and next
		// value in middle variable and keep Traversal and if we found again the same
		// condition
		// we will keep the last element in the last variable.
		// At last we will check:
		// 1. If first and last are there we will swap
		// 2. If last is not there, we will swap first and middle.
		// T.C = O(N) , S.C = O(N, Auxiliary Space)

		// Efficient Solution
		// In this the S.C will O(1) as we will use Mores Traversal

		// We will do using Better Solution

		RecoverNode root = new RecoverNode(5);
		root.left = new RecoverNode(2);
		root.right = new RecoverNode(8);
		root.left.left = new RecoverNode(4);
		root.left.right = new RecoverNode(3);
		root.right.right = new RecoverNode(9);
		root.right.left = new RecoverNode(6);

		recoverTree(root);

	}

}
