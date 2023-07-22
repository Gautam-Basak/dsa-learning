package BinarySearchTree.Problems;

class kThSmallestNode {
	int data;
	kThSmallestNode left, right;

	kThSmallestNode(int val) {
		data = val;
		left = null;
		right = null;
	}
}

public class KthSmallestElementInBST {

	public static kThSmallestNode insertNode(kThSmallestNode root, int val) {

		if (root == null)
			return new kThSmallestNode(val);

		if (val < root.data) {
			root.left = insertNode(root.left, val);
		} else {
			root.right = insertNode(root.right, val);
		}

		return root;

	}

	private static kThSmallestNode kthSmallest(kThSmallestNode root, int[] k) {

		if (root == null)
			return null;

		kThSmallestNode left = kthSmallest(root.left, k);

		if (left != null)
			return left;

		k[0]--;
		if (k[0] == 0)
			return root;

		return kthSmallest(root.right, k);
	}

	public static void main(String[] args) {

		// We will use In-Order Traversal (i.e Left -> Root -> Right).
		// The In-Order traversal gives return the elements in increasing sorted order,
		// so we can easing find the k'yh smallest element.

		int arr[] = { 10, 40, 45, 20, 25, 30, 50 };

		int k = 2;
		kThSmallestNode root = null;

		for (int i = 0; i < arr.length; i++) {
			root = insertNode(root, arr[i]);
		}

		// If we pass "k" as an argument we have maintain a "count" and compare with
		// "k".
		// We have to pass an array with "k" as a Value, so that we can decrease the
		// value of "k" and once it is equal to 0 means we find the element.

		// I will try passing Array in the problem and I will pass k as an argument in
		// kthLargest problem
		kThSmallestNode small = kthSmallest(root, new int[] { k });

		if (small == null) {
			System.out.println("Invalid input");
		} else
			System.out.println("kth largest element is  " + small.data);

	}
}
