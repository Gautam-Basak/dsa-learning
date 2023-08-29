package BinarySearchTree.Problems;

class TreeNode {
	int data;
	TreeNode left, right;

	TreeNode(int val) {
		data = val;
		left = null;
		right = null;
	}
}

public class ConstructBSTfromPreOrderTraversal {

	public static void main(String[] args) {

		// The idea is taken from problem CheckIfTreeBSTorNot, where we checked through
		// upper and lower bound.

		// Here in this, the problem will be solved keeping only upper bound.
		int[] preOrder = { 8, 5, 1, 7, 10, 12 };
		int i = 0;
		TreeNode ans = constructBST(preOrder, Integer.MAX_VALUE, new int[] { i });
		System.out.println(ans.data);
	}

	private static TreeNode constructBST(int[] A, int bound, int[] i) {

		// This 1st condition checks whether the current index i[0] has reached the end
		// of the array A
		if (i[0] == A.length || A[i[0]] > bound)
			return null;

		// This "[i[0]++]" will contain only one element but the value of that element
		// will increase and at the top we are checking the incremented value with the
		// length of the Array
		TreeNode root = new TreeNode(A[i[0]++]);

		// As we are computing with only Upper Bound value.

		// So when we are going left we are checking with the root.value(which is the
		// upper bound) and when we are going right we are checking the the previous
		// Upper bound

		// So in the first checking if we are going left side, then on the entire left
		// side whether we are going left or right the Upper bound will be the
		// root.value itself.

		// Or in the first checking if we are going right side then on the entire right
		// side if we are going right the Upper bound will be the Integer.MaxValue and
		// if we go on the left the Upper bound will be the root.value.
		root.left = constructBST(A, root.data, i);
		root.right = constructBST(A, bound, i);

		return root;
	}

}
