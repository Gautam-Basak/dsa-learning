package BinarySearchTree.Problems;

import java.util.Stack;

class BSTIteratorNode {
	int data;
	BSTIteratorNode left;
	BSTIteratorNode right;

	BSTIteratorNode(int data) {
		this.data = data;
		left = right = null;
	}
}

public class BSTIterator {

	private Stack<BSTIteratorNode> stack = new Stack<BSTIteratorNode>();

	public BSTIterator(BSTIteratorNode root) {

		pushAll(root);

	}

	public boolean hashNext() {
		return !stack.isEmpty();
	}

	public int next() {
		
		BSTIteratorNode temNode = stack.peek();
		pushAll(temNode.right);
		stack.pop();
		
		return temNode.data;
	}

	private void pushAll(BSTIteratorNode root) {

		for (; root != null; stack.push(root), root = root.left)
			;

	}

	public static void main(String[] args) {

		BSTIteratorNode root = new BSTIteratorNode(8);
		root.right = new BSTIteratorNode(9);
		root.left = new BSTIteratorNode(3);
		root.left.left = new BSTIteratorNode(2);
		root.left.right = new BSTIteratorNode(4);
		root.left.right.right = new BSTIteratorNode(5);

		// We will follow InOrder, to collect the element in Stack

		BSTIterator itr = new BSTIterator(root);

		System.out.println(itr.next());
		System.out.println(itr.hashNext());
	}

}
