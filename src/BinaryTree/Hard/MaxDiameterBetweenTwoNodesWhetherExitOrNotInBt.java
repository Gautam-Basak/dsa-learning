package BinaryTree.Hard;

import java.util.LinkedList;
import java.util.Queue;

class MaxDiaNode {
	int data;
	MaxDiaNode left, right;

	MaxDiaNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class Pair {
	MaxDiaNode node;
	int num;

	Pair(MaxDiaNode _node, int _num) {
		num = _num;
		node = _node;
	}
}

public class MaxDiameterBetweenTwoNodesWhetherExitOrNotInBt {

	public static void main(String[] args) {

		MaxDiaNode root = new MaxDiaNode(1);
		root.left = new MaxDiaNode(3);
		root.left.left = new MaxDiaNode(5);
		root.left.left.left = new MaxDiaNode(7);
		root.right = new MaxDiaNode(2);
		root.right.right = new MaxDiaNode(4);
		root.right.right.right = new MaxDiaNode(6);

		System.out.println(maxWidthOfBinaryTree(root));
	}

	private static int maxWidthOfBinaryTree(MaxDiaNode root) {

		if (root == null)
			return 0;

		int ans = 0;
		Queue<Pair> q = new LinkedList<>();

		q.offer(new Pair(root, 0));
		while (!q.isEmpty()) {

			int size = q.size();

			// We will subtract the min value from every num on each level, so that it
			// overcome the overflow while calculating the num of next level
			int min = q.peek().num;
			int first = 0, last = 0;
			for (int i = 0; i < size; i++) {
				int cur_id = q.peek().num - min;
				MaxDiaNode node = q.peek().node;
				q.poll();

				if (i == 0)
					first = cur_id;

				if (i == size - 1)
					last = cur_id;

				if (node.left != null)
					q.offer(new Pair(node.left, cur_id * 2 + 1));

				if (node.right != null)
					q.offer(new Pair(node.right, cur_id * 2 + 2));
			}
			ans = Math.max(ans, last - first + 1);
		}

		return ans;

	}

}
