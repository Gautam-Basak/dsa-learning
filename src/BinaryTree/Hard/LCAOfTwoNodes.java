package BinaryTree.Hard;

class LCANode {

	int val;
	LCANode left, right;

	public LCANode() {

	}

	public LCANode(int key) {

		this.val = key;

	}
}

public class LCAOfTwoNodes {

	public static void main(String[] args) {

		// The Lowest Common Ancestor of two nodes is the Lowest(Highest wise which is
		// below) Common Root Node

		LCANode root = new LCANode(100);
		root.left = new LCANode(120);
		root.left.left = new LCANode(200);
		root.left.right = new LCANode(2);
		root.right = new LCANode(30);
		root.right.right = new LCANode(60);
		root.right.right.right = new LCANode(70);
		root.right.left = new LCANode(10);
		root.right.left.left = new LCANode(20);
		
		//T.C = O(N) , S.C = O(N) Auxiliary Space/ Stack Space
		LCANode ans = findLCA(root, root.left, root.right.right.right);
		System.out.println(ans.val);

	}

	private static LCANode findLCA(LCANode root, LCANode p, LCANode q) {

		// If we find any one of that, at same time return no need to go further
		// If we reach leaf node return simple null
		if (root == null || root == p || root == q)
			return root;

		LCANode left = findLCA(root.left, p, q);
		LCANode right = findLCA(root.right, p, q);

		if (left == null)
			return right;

		else if (right == null)
			return left;

		else // Both left and right are not null, we found our result
			return root;
	}

}
