package BinaryTree.Hard;

import java.util.ArrayList;

class RootToNodePathNode {

	int val;
	RootToNodePathNode left, right;

	public RootToNodePathNode() {

	}

	public RootToNodePathNode(int key) {

		this.val = key;

	}
}

public class RootToNodePathInBT {

	private static boolean getPath(RootToNodePathNode root, ArrayList<Integer> res, int x) {

		if (root == null)
			return false;

		res.add(root.val);
		if (root.val == x)
			return true;

		if (getPath(root.left, res, x) || getPath(root.right, res, x))
			return true;

		res.remove(res.size() - 1);
		return false;
	}

	private static ArrayList<Integer> solve(RootToNodePathNode root, int x) {

		ArrayList<Integer> res = new ArrayList<>();

		if (root == null)
			return res;

		getPath(root, res, x);
		return res;
	}

	public static void main(String[] args) {

		RootToNodePathNode root = new RootToNodePathNode(100);
		root.left = new RootToNodePathNode(120);
		root.left.left = new RootToNodePathNode(200);
		root.left.right = new RootToNodePathNode(2);
		root.right = new RootToNodePathNode(30);
		root.right.right = new RootToNodePathNode(60);
		root.right.right.right = new RootToNodePathNode(70);
		root.right.left = new RootToNodePathNode(10);
		root.right.left.left = new RootToNodePathNode(20);

		int x = 20;
		ArrayList<Integer> ans = solve(root, x);

		// The path to reach 20 from root is (100 -> 30 -> 10 -> 20)
		System.out.println(ans);

	}
}
