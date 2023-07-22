package BinarySearchTree.Problems;

public class SearchInBST {

	static class Node {
		int data;
		Node left;
		Node right;
	}

	static Node newNode(int val) {
		Node temp = new Node();
		temp.data = val;
		temp.left = temp.right = null;
		return temp;
	}

	private static Node searchBST(Node root, int key) {

		while (root != null && root.data != key) {

			root = key < root.data ? root.left : root.right;
		}
		return root;
	}

	public static void main(String[] args) {

		Node root = newNode(15);
		root.left = newNode(10);
		root.right = newNode(20);
		root.left.left = newNode(5);
		root.left.right = newNode(12);
		root.right.right = newNode(25);

		int key = 12;

		Node node = (searchBST(root, key));
		if (node == null)
			System.out.println("Key doesn't exist");
		else
			System.out.println(node.data);
	}
}
