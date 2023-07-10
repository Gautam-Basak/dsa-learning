package BinaryTree.Traversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class LevelOrderNode {
	int data;
	LevelOrderNode left, right;

	LevelOrderNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	LevelOrderNode() {

	}
}

public class BTLevelOrderTraversal {

	public static void main(String[] args) {

		LevelOrderNode root = new LevelOrderNode(1);
		root.left = new LevelOrderNode(2);
		root.right = new LevelOrderNode(3);
		root.left.left = new LevelOrderNode(4);
		root.left.right = new LevelOrderNode(5);
		root.right.left = new LevelOrderNode(6);
		root.right.right = new LevelOrderNode(7);
		root.left.left.left = new LevelOrderNode(8);
		root.left.left.right = new LevelOrderNode(9);
		root.left.right.left = new LevelOrderNode(10);
		root.left.right.right = new LevelOrderNode(11);
		root.right.left.left = new LevelOrderNode(12);
		root.right.left.right = new LevelOrderNode(13);
		root.right.right.left = new LevelOrderNode(14);
		root.right.right.right = new LevelOrderNode(15);

		ArrayList<Integer> levelOrder = levelOrderTraversal(root);
		System.out.print(levelOrder);

	}

	private static ArrayList<Integer> levelOrderTraversal(LevelOrderNode root) {

		Queue<LevelOrderNode> queue = new LinkedList<LevelOrderNode>();
		ArrayList<Integer> wrapList = new ArrayList<Integer>();

		if (root == null)
			return wrapList;
		
		queue.offer(root);
		
		while(!queue.isEmpty()) {
			
			if(queue.peek().left != null) {
				queue.offer(queue.peek().left);
			}
			
			if(queue.peek().right != null) {
				queue.offer(queue.peek().right);
			}
			
			wrapList.add(queue.poll().data);
		}
		
		
		return wrapList;
	}

}
