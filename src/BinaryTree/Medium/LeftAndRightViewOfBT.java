package BinaryTree.Medium;

import java.util.ArrayList;
import java.util.List;

class LeftAndRightViewNode {

	int val;
	LeftAndRightViewNode left, right;

	public LeftAndRightViewNode() {

	}

	public LeftAndRightViewNode(int key) {

		this.val = key;

	}
}

public class LeftAndRightViewOfBT {

	// Left View
	private static void leftSideView(LeftAndRightViewNode curr, List<Integer> result, int currDepth) {

		if (curr == null)
			return;

		if (currDepth == result.size())
			result.add(curr.val);

		leftSideView(curr.left, result, currDepth + 1);
		leftSideView(curr.right, result, currDepth + 1);

	}

	private static List<Integer> leftViewBT(LeftAndRightViewNode root) {

		List<Integer> result = new ArrayList<>();

		leftSideView(root, result, 0);
		return result;
	}

	public static void main(String[] args) {

		// Note - We will do Pre-Order Traversal (Root - Left - Right) for Left View and
		// Reverse Pre-Order Traversal (Root - Right - Left) for Right View.

		// Reasons for Left View
		// For Left View we will see from Left side, so after Root we will go to
		// "root.left" and so on recursively to get the Left Node at First and then will
		// go to Right Node and this is how it satisfy Pre-Order Traversal

		// Reasons for Right View
		// For Right View we will see from Right side, so after Root we will go to
		// "root.right" and so on recursively to get the Right Node at First and then
		// will go to Left Node and this is how it satisfy
		// Reverse Pre-Order Traversal

		// How it avoids the middle element?
		// Simple trick whenever we go the any node, we will check if(level ==
		// arraylist.size) and if it given true we will add the element in the
		// arraylist.

		// For Example - When we traverse for left view, after the root element we will
		// go to Left Node and at that time level will be one and size will also be one
		// as the arraylist consist of only one element i.e root element after that if
		// we go to Right Node from that point i.e from the Left Node, we increase the
		// size of level as we pass the level in every recursion call but at that time
		// the size of arraylist will be higher than the level that is how we
		// avoid Right Node at the same Level

		LeftAndRightViewNode root = new LeftAndRightViewNode(1);
		root.left = new LeftAndRightViewNode(2);
		root.left.left = new LeftAndRightViewNode(3);
		root.left.left.right = new LeftAndRightViewNode(4);
		root.left.left.right.left = new LeftAndRightViewNode(5);
		root.left.left.right.right = new LeftAndRightViewNode(6);
		root.right = new LeftAndRightViewNode(7);
		root.right.right = new LeftAndRightViewNode(8);
		root.right.right.left = new LeftAndRightViewNode(9);
		root.right.right.left.left = new LeftAndRightViewNode(10);
		root.right.right.left.right = new LeftAndRightViewNode(11);

		// Root -> Left -> Right
		List<Integer> ans1 = leftViewBT(root);
		System.out.print(ans1 + " ");

		System.out.println();

		//// Root -> Right -> Left
		List<Integer> ans2 = rightViewBT(root);
		System.out.print(ans2 + " ");

	}

	private static List<Integer> rightViewBT(LeftAndRightViewNode root) {

		List<Integer> result = new ArrayList<>();

		rightViewBT(root, result, 0);
		return result;
	}

	private static void rightViewBT(LeftAndRightViewNode curr, List<Integer> result, int currDepth) {

		if (curr == null)
			return;

		if (currDepth == result.size())
			result.add(curr.val);

		leftSideView(curr.right, result, currDepth + 1);
		leftSideView(curr.left, result, currDepth + 1);

	}
}
