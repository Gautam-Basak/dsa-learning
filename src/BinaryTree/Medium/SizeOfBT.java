package BinaryTree.Medium;

class SizeNode {

	int val;
	SizeNode left, right;

	public SizeNode() {

	}

	public SizeNode(int key) {

		this.val = key;

	}
}

public class SizeOfBT {
	
	private static int getSize(SizeNode root) {
		
		if(root == null)
			return 0;	
		
		return 1 + getSize(root.left) + getSize(root.right);
	}


	public static void main(String[] args) {
		
		
		SizeNode root = new SizeNode(100);
		root.left = new SizeNode(2);
		root.right = new SizeNode(3);
		root.right.right = new SizeNode(4);
		root.right.right.right = new SizeNode(9);
		
		System.out.println(getSize(root));

	}
}
