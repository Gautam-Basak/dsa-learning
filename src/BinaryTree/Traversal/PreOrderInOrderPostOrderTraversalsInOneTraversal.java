package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode() {
	}

	public TreeNode(int key) {

		this.val = key;
	}
}

class Pair {
	TreeNode node;
	int num;

	public Pair(TreeNode _node, int _num) {

		this.node = _node;
		this.num = _num;
	}
}

public class PreOrderInOrderPostOrderTraversalsInOneTraversal {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		List<Integer> pre = new ArrayList<>();
		List<Integer> in = new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		allTraversal(root, pre, in, post);
		
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);

	}

	private static void allTraversal(TreeNode root, List<Integer> pre, List<Integer> in, List<Integer> post) {

		Stack<Pair> s = new Stack<>();
		s.push(new Pair(root, 1));

		if (root == null)
			return;

		while (!s.isEmpty()) {

			Pair it = s.pop();

			// this is part of pre
			// increment 1 to 2
			// push the left side of the tree
			if (it.num == 1) {

				pre.add(it.node.val);
				it.num++;
				s.push(it);

				if (it.node.left != null) {
					s.push(new Pair(it.node.left, 1));
				}
			}
			
			// this is a part of in 
            // increment 2 to 3 
            // push right
			else if (it.num == 2) {

				in.add(it.node.val);
				it.num++;
				s.push(it);

				if (it.node.right != null) {
					s.push(new Pair(it.node.right, 1));
				}
			}
			else {
				post.add(it.node.val);
			}
		}

	}

}
