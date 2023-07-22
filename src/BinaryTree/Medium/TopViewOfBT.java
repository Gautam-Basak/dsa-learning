package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

class TopViewNode {

	int val;
	TopViewNode left, right;

	public TopViewNode() {

	}

	public TopViewNode(int key) {

		this.val = key;

	}
}

class Pair {

	TopViewNode node;
	int ver;

	public Pair(TopViewNode node, int key) {

		this.node = node;
		ver = key;

	}
}

// Use Level Order Traversal
public class TopViewOfBT {

	public static void main(String[] args) {
		
		TopViewNode root = new TopViewNode(1);
		root.left = new TopViewNode(2);
		root.left.left = new TopViewNode(3);
		root.left.left.right = new TopViewNode(4);
		root.left.left.right.left = new TopViewNode(5);
		root.left.left.right.right = new TopViewNode(6);
		root.right = new TopViewNode(7);
		root.right.right = new TopViewNode(8);
		root.right.right.left = new TopViewNode(9);
		root.right.right.left.left = new TopViewNode(10);
		root.right.right.left.right = new TopViewNode(11);

		List<Integer> list = new ArrayList<>();
		list = topView(root);
		
		System.out.println("The Top View Of BT : ");
        for (Integer it: list) {
            System.out.print(it + " ");
        }


	}

	private static List<Integer> topView(TopViewNode root) {
		
		List<Integer> ans = new ArrayList<>();
		if(root== null)
			return ans;
		
		Map<Integer, Integer> map = new TreeMap<>();
		Queue<Pair> q = new LinkedList<>();
		
		q.offer(new Pair(root, 0));
		while(!q.isEmpty()) {
			
			Pair pair = q.poll();
			
			TopViewNode node = pair.node;
			int ver = pair.ver;
			
			if (!map.containsKey(ver)) {
				map.put(ver, node.val);
			}
			
			if (node.left != null) {
				q.offer(new Pair(node.left, ver-1));
			}

			if (node.right != null) {
				q.offer(new Pair(node.right, ver+1));
			}
		}
		for(Map.Entry<Integer, Integer> mp : map.entrySet()) {
			ans.add(mp.getValue());
		}
		return ans;
	}

}
