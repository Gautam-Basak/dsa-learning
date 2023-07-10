package BinaryTree.Medium;

import java.util.LinkedList;
import java.util.Queue;

class HeightNode {

	int val;
	HeightNode left, right;

	public HeightNode() {

	}

	public HeightNode(int key) {

		this.val = key;

	}
}

public class HeightOfBinaryTree {

	// Approach: Using LEVEL ORDER TRAVERSAL
	private static int heightOfBTRecursiveOptimal(HeightNode root) {

		if (root == null)
			return 0;

		int lh = heightOfBTRecursiveOptimal(root.left);
		int rh = heightOfBTRecursiveOptimal(root.right);

		return 1 + Math.max(lh, rh);
	}

	// Recursively ( Post Order Traversal )
	private static int heightOfBTNaive(HeightNode root) {

		if (root == null)
			return 0;

		int level = 0;
		Queue<HeightNode> q = new LinkedList<>();
		q.offer(root);

		while (q.size() > 0) {

			int size = q.size();

			while (size-- > 0) {

				HeightNode remNode = q.poll();

				if (remNode.left != null) {
					q.add(remNode.left);
				}

				if (remNode.right != null) {
					q.add(remNode.right);
				}
			}

			level++;

		}

		return level;
	}

	public static void main(String[] args) {

		HeightNode root = new HeightNode(1);
		root.left = new HeightNode(2);
		root.right = new HeightNode(3);
		root.left.left = new HeightNode(4);
		root.left.right = new HeightNode(5);
		root.right.left = new HeightNode(6);
		root.right.right = new HeightNode(7);
		root.left.left.left = new HeightNode(8);
		root.left.left.right = new HeightNode(9);
		root.left.right.left = new HeightNode(10);
		root.left.right.right = new HeightNode(11);
		root.right.left.left = new HeightNode(12);
		root.right.left.right = new HeightNode(13);
		root.right.right.left = new HeightNode(14);
		root.right.right.right = new HeightNode(15);

		// Naive Solution
		// Time Complexity: O(N)
		// Space Complexity: O(N) (Queue data structure is used)
		// Using LEVEL ORDER TRAVERSAL
		System.out.println(heightOfBTNaive(root));

		// Time Complexity: O(N)
		// Space Complexity: O(1) Extra Space + O(H) Recursion Stack space, where “H” is
		// the height of the binary tree.
		System.out.println(heightOfBTRecursiveOptimal(root));
	}
}
