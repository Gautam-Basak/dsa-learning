package BinarySearchTree.Problems;

import java.util.Stack;

class TwoSumNode {
	int data;
	TwoSumNode left;
	TwoSumNode right;

	TwoSumNode(int data) {
		this.data = data;
		left = right = null;
	}

}

public class TwoSumInBST {

	private Stack<TwoSumNode> stack = new Stack<TwoSumNode>();
	boolean reverse = true;

	public TwoSumInBST(TwoSumNode root, boolean isReverse) {
		// reverse -> true -> Before
		// reverse -> false -> After
		reverse = isReverse;

		pushAll(root);

	}

	public boolean hasNext() {
		return !stack.isEmpty();
	}

	public int next() {
		TwoSumNode tempNode = stack.peek();

		if (reverse == false) {
			pushAll(tempNode.right);
		} else {
			pushAll(tempNode.left);
		}
		stack.pop();

		return tempNode.data;
	}

	private void pushAll(TwoSumNode root) {

		while (root != null) {
			stack.push(root);

			if (reverse == true) {
				root = root.right;
			} else {
				root = root.left;
			}

		}
	}

	private static boolean findTarget(TwoSumNode root, int k) {

		if (root == null)
			return false;
		// Next
		TwoSumInBST l = new TwoSumInBST(root, false);
		// Before
		TwoSumInBST r = new TwoSumInBST(root, true);

		int i = l.next();
		int j = r.next();

		while (i < j) {

			if (i + j == k)
				return true;

			else if (i + j < k)
				i = l.next();

			else
				j = r.next();
		}
		return false;
	}

	public static void main(String[] args) {

		TwoSumNode root = new TwoSumNode(8);
		root.right = new TwoSumNode(9);
		root.left = new TwoSumNode(3);
		root.left.left = new TwoSumNode(2);
		root.left.right = new TwoSumNode(4);
		root.left.right.right = new TwoSumNode(5);

		// We will follow InOrder, to collect Before and After element in Stack
		TwoSumInBST itr = new TwoSumInBST(root, false);

		System.out.println(itr.next());
		System.out.println(itr.hasNext());

		// Then check if there exist a pair with sum "K"
		int k = 14;

		if (findTarget(root, k))
			System.out.println("Exists a pair with sum K");
		else
			System.out.println("Not exists a pair with sum K");

	}

}
