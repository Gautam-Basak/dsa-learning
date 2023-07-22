package BinarySearchTree.Problems;

class LcaBSTNode {

	int val;
	LcaBSTNode left, right;

	public LcaBSTNode() {

	}

	public LcaBSTNode(int key) {

		this.val = key;

	}
}

public class LCAOfTwoNodesInBST {

	public static void main(String[] args) {

		LcaBSTNode root = new LcaBSTNode(5);
		root.left = new LcaBSTNode(2);
		root.right = new LcaBSTNode(8);
		root.left.left = new LcaBSTNode(1);
		root.left.right = new LcaBSTNode(3);
		root.right.right = new LcaBSTNode(9);
		root.right.left = new LcaBSTNode(6);

		// If we apply the same concept of LCA in BT we will end up with
		// T.C = O(N) ,S.C = O(N) Auxiliary Space

		// But for BST, we always optimized or try to optimized to TC = O(Height of the
		// Tree) and S.C = O(N) Auxiliary Space/ Stack Space, if we use recursion.
		LcaBSTNode ans = findLcaInBST(root, root.left.left, root.left.right);
		System.out.println(ans.val);
	}

	private static LcaBSTNode findLcaInBST(LcaBSTNode root, LcaBSTNode p, LcaBSTNode q) {

		if (root == null)
			return null;

		// I followed three process

		// 1st - Both(p and q) are on the Left Side
		int cur = root.val;
		if (p.val < cur && q.val < cur)
			return findLcaInBST(root.left, p, q);

		// 2nd - Both(p and q) are on the Right Side
		if (p.val > cur && q.val > cur)
			return findLcaInBST(root.right, p, q);

		// 3rd - If one is on Left and Another one is on Right
		return root;
	}

}
