package BinarySearchTree.Problems;

class FloorNode {

	int val;
	FloorNode left, right;

	public FloorNode() {

	}

	public FloorNode(int key) {

		this.val = key;

	}
}

public class FloorInBST {

	public static void main(String[] args) {

		FloorNode root = new FloorNode(5);
		root.left = new FloorNode(2);
		root.right = new FloorNode(8);
		root.left.left = new FloorNode(1);
		root.left.right = new FloorNode(3);
		root.right.right = new FloorNode(9);
		root.right.left = new FloorNode(6);

		int key = 12;

		System.out.println(findFloor(root, key));

	}

	private static int findFloor(FloorNode root, int key) {

		int floor = -1;

		while (root != null) {

			if (root.val == key) {
				floor = root.val;
				return floor;
			}

			if (key < root.val) {
				root = root.left;
			} else {
				floor = root.val;
				root = root.right;
			}
		}
		return floor;
	}

}
