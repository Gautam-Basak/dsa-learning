package BinarySearchTree.Problems;

class LargestBSTNode {
	int data;
	LargestBSTNode left, right;

	LargestBSTNode(int val) {
		data = val;
		left = null;
		right = null;
	}
}

class NodeValue {
	public int maxNode, minNode, maxSize;

	NodeValue(int minNode, int maxNode, int maxSize) {
		this.minNode = minNode;
		this.maxNode = maxNode;
		this.maxSize = maxSize;
	}
}

public class LargestBSTInBT {

	private static NodeValue largestBSTSubtreeHelper(LargestBSTNode root) {

		// An empty tree is a BST of size 0.
		if (root == null) {
			return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		// Get values from left and right subtree of current tree.
		NodeValue left = largestBSTSubtreeHelper(root.left);
		NodeValue right = largestBSTSubtreeHelper(root.right);

		// Current node is greater than max in left AND smaller than min in right, it is
		// a BST.
		if (left.maxNode < root.data && root.data < right.minNode) {
			// It is a BST.
			return new NodeValue(Math.min(root.data, left.minNode), Math.max(root.data, right.maxNode),
					left.maxSize + right.maxSize + 1);
		}

		// Otherwise, return [-inf, inf] so that parent can't be valid BST
		return new NodeValue(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.maxSize, right.maxSize));

	}
	
	private static int largestBSTSubtree(LargestBSTNode root) {
        return largestBSTSubtreeHelper(root).maxSize;
    }

	public static void main(String[] args) {

		LargestBSTNode root = new LargestBSTNode(10);
		root.right = new LargestBSTNode(3);
		root.left = new LargestBSTNode(5);
		root.left.left = new LargestBSTNode(3);
		root.left.left.left = new LargestBSTNode(2);
		root.left.left.right = new LargestBSTNode(4);
		root.left.right = new LargestBSTNode(6);

		largestBSTSubtreeHelper(root);
		
		System.out.println(largestBSTSubtree(root));

	}

}
