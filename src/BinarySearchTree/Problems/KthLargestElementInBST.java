package BinarySearchTree.Problems;

class kThLargestNode {
	int data;
	kThLargestNode left, right;

	kThLargestNode(int val) {
		data = val;
		left = null;
		right = null;
	}
}

public class KthLargestElementInBST {

	public static kThLargestNode insertNode(kThLargestNode root, int val) {

		if (root == null)
			return new kThLargestNode(val);

		if (val < root.data) {
			root.left = insertNode(root.left, val);
		} else {
			root.right = insertNode(root.right, val);
		}

		return root;

	}

	static int count = 0;

	private static kThLargestNode kthLargest(kThLargestNode root, int[] k) {

		if (root == null)
			return null;

		kThLargestNode right = kthLargest(root.right, k);

		if (right != null)
			return right;

		k[0]--;
		if (k[0] == 0)
			return root;

		return kthLargest(root.left, k);
	}

	public static void main(String[] args) {

		// We will use In-Order Traversal (i.e Left -> Root -> Right).
		// The In-Order traversal gives return the elements in increasing sorted order,
		// so we can easing find the k'yh smallest element.

		int arr[] = { 10, 40, 45, 20, 25, 30, 50 };

		int k = 2;
		kThLargestNode root = null;

		for (int i = 0; i < arr.length; i++) {
			root = insertNode(root, arr[i]);
		}

		// If we pass "k" as an argument we have maintain a "count" and compare with
		// "k".
		// We have to pass an array with "k" as a Value, so that we can decrease the
		// value of "k" and once it is equal to 0 means we find the element.

		// I will try passing Array in the problem and I will pass k as an argument in
		// kthLargest problem
		kThLargestNode large = kthLargest(root, new int[] { k });

		if (large == null) {
			System.out.println("Invalid input");
		} else
			System.out.println("kth largest element is  " + large.data);

	}
}
