package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class ZigZagNode {

	int val;
	ZigZagNode left, right;

	public ZigZagNode() {

	}

	public ZigZagNode(int key) {

		this.val = key;

	}
}

public class ZigZagTraversalOfBT {

	private static ArrayList<ArrayList<Integer>> zigzagLevelOrder(ZigZagNode root) {

		ArrayList<ArrayList<Integer>> wrapList = new ArrayList<>();
		Queue<ZigZagNode> q = new LinkedList<ZigZagNode>();
		boolean flag = true;

		if (root == null)
			return wrapList;

		q.offer(root);
		while (!q.isEmpty()) {

			int size = q.size();
			ArrayList<Integer> subList = new ArrayList<>(size);

			for (int i = 0; i < size; i++) {

				if (q.peek().left != null) {
					q.offer(q.peek().left);
				}

				if (q.peek().right != null) {
					q.offer(q.peek().right);
				}
				if (flag == true) {
					subList.add(q.poll().val);
				} else {
					subList.add(0, q.poll().val);
				}
			}
			flag = !flag;
			wrapList.add(subList);
		}
		return wrapList;
	}

	public static void main(String args[]) {
		ZigZagNode root = new ZigZagNode(3);
		root.left = new ZigZagNode(9);
		root.right = new ZigZagNode(20);
		root.right.left = new ZigZagNode(15);
		root.right.right = new ZigZagNode(7);

		ArrayList<ArrayList<Integer>> ans;
		ans = zigzagLevelOrder(root);

		for (int i = 0; i < ans.size(); i++) {
			for (int j = 0; j < ans.get(i).size(); j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}
}