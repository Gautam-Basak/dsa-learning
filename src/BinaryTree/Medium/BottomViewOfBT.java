package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class BottomViewNode {

	int val;
	BottomViewNode left, right;

	public BottomViewNode() {

	}

	public BottomViewNode(int key) {

		this.val = key;

	}
}

class PairBottom {

	BottomViewNode node;
	int ver;

	public PairBottom(BottomViewNode node, int key) {

		this.node = node;
		ver = key;

	}
}

public class BottomViewOfBT {

	private static List<Integer> bottomView(BottomViewNode root) {

		List<Integer> ans = new ArrayList<>();
		if (root == null)
			return ans;

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<PairBottom> q = new LinkedList<>();

		q.offer(new PairBottom(root, 0));
		while (!q.isEmpty()) {

			PairBottom pair = q.poll();

			BottomViewNode node = pair.node;
			int ver = pair.ver;

			map.put(ver, node.val);

			if (node.left != null) {
				q.offer(new PairBottom(node.left, ver - 1));
			}

			if (node.right != null) {
				q.offer(new PairBottom(node.right, ver + 1));
			}
		}
		for (Map.Entry<Integer, Integer> mp : map.entrySet()) {
			ans.add(mp.getValue());
		}
		return ans;
	}

	// Note : If two nodes overlap print the right node.

	public static void main(String[] args) {

		BottomViewNode root = new BottomViewNode(1);
		root.left = new BottomViewNode(2);
		root.left.left = new BottomViewNode(3);
		root.left.left.right = new BottomViewNode(4);
		root.left.left.right.left = new BottomViewNode(5);
		root.left.left.right.right = new BottomViewNode(6);
		root.right = new BottomViewNode(7);
		root.right.right = new BottomViewNode(8);
		root.right.right.left = new BottomViewNode(9);
		root.right.right.left.left = new BottomViewNode(10);
		root.right.right.left.right = new BottomViewNode(11);

		List<Integer> list = new ArrayList<>();
		list = bottomView(root);

		System.out.println("The Top View Of BT : ");
		for (Integer it : list) {
			System.out.print(it + " ");
		}
	}
}
