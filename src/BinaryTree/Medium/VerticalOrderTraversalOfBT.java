package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

class VerticalNode {

	int val;
	VerticalNode left, right;

	public VerticalNode() {

	}

	public VerticalNode(int key) {

		this.val = key;

	}
}

class Tuple {

	VerticalNode node;
	int ver, lev;

	public Tuple(VerticalNode node, int vertical, int level) {

		this.node = node;
		ver = vertical;
		lev = level;
	}
}

public class VerticalOrderTraversalOfBT {

	public static void main(String[] args) {

		VerticalNode root = new VerticalNode(1);
		root.left = new VerticalNode(2);
		root.left.left = new VerticalNode(4);
		root.left.right = new VerticalNode(10);
		root.left.left.right = new VerticalNode(5);
		root.left.left.right.right = new VerticalNode(6);
		root.right = new VerticalNode(3);
		root.right.left = new VerticalNode(9);
		root.right.right = new VerticalNode(10);

		List<List<Integer>> list = new ArrayList<>();
		list = findVertical(root);
		
		System.out.println("The Vertical Traversal is : ");
        for (List < Integer > it: list) {
            for (int nodeVal: it) {
                System.out.print(nodeVal + " ");
            }
            System.out.println();
        }

	}

	private static List<List<Integer>> findVertical(VerticalNode root) {

		// TreeMap<Vertical, TreeMap<Level, PriorityQueue<Integer>>> map = new TreeMap
		// <> ();
		// It satisfy everything, against each Vertical we will again use TreeMap to
		// store nodes level-wise inside the vertical

		TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
		Queue<Tuple> q = new LinkedList<>();

		q.offer(new Tuple(root, 0, 0));
		while (!q.isEmpty()) {

			Tuple tuple = q.poll();

			VerticalNode node = tuple.node;
			int x = tuple.ver;
			int y = tuple.lev;

			if (!map.containsKey(x)) {
				map.put(x, new TreeMap<>());
			}

			if (!map.get(x).containsKey(y)) {
				map.get(x).put(y, new PriorityQueue<>());
			}

			map.get(x).get(y).offer(node.val);

			if (node.left != null) {
				q.offer(new Tuple(node.left, x - 1, y + 1));
			}

			if (node.right != null) {
				q.offer(new Tuple(node.right, x + 1, y + 1));
			}

		}

		List<List<Integer>> list = new ArrayList<>();

		for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
			list.add(new ArrayList<>());
			for (PriorityQueue<Integer> nodes : ys.values()) {
				while (!nodes.isEmpty()) {
					list.get(list.size() - 1).add(nodes.poll());
				}
			}
		}

		return list;
	}

}
