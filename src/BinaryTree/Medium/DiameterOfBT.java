package BinaryTree.Medium;

class DiameterNode {

	int val;
	DiameterNode left, right;

	public DiameterNode() {

	}

	public DiameterNode(int key) {

		this.val = key;

	}
}

public class DiameterOfBT {

	static int diameter = Integer.MIN_VALUE;

	public static int diameterOfBT(DiameterNode root) {

		if (root == null)
			return 0;

		int lh = diameterOfBT(root.left);
		int rh = diameterOfBT(root.right);

		diameter = Math.max(diameter, lh + rh);

		return 1 + Math.max(lh, rh);
	}

	public static void main(String[] args) {

		// Highest distance between two nodes of any subTree or main tree.

		DiameterNode root = new DiameterNode(10);
		root.left = new DiameterNode(20);
		root.right = new DiameterNode(30);
		root.left.left = new DiameterNode(40);
		root.right.right = new DiameterNode(60);
		root.left.left.left = new DiameterNode(50);
		root.right.right.right = new DiameterNode(70);

		System.out.println("Height of BT " + diameterOfBT(root));
		System.out.println("Diameter of BT " + diameter);

	}

}
