package Stack.Monotonic;

import java.util.Stack;

public class NextGreaterOfCircularArray {

	public static void main(String[] args) {

		// For any particular element we will find the next greater element in clockwise
		// direction.
		// If it is not found till the end, we will check from beginning till that
		// element.

		int[] arr = { 2, 10, 12, 1, 11 };

		// Trick - To check whether a string is circular of the original string or not,
		// we add original plus original(s1 + s1) string then we check
		// the rotated string exist or not in (s1 + s1).
		// If the string is rotated it will return true else false

		int arr2[] = printNextGreater(arr, arr.length);
		System.out.println("The next greater elements are ");
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

	}

	 public static int[] printNextGreater(int[] nums, int n) {
	        
	        int nge[] = new int[n];
	        Stack < Integer > st = new Stack < > ();
	        for (int i = 2 * n - 1; i >= 0; i--) {
	            while (st.isEmpty() == false && st.peek() <= nums[i % n]) {
	                st.pop();
	            }

	            if (i < n) {
	                if (st.isEmpty() == false) 
	                	nge[i] = st.peek();
	                else
	                	nge[i] = -1;
	            }

	            st.push(nums[i % n]);
	        }
	        return nge;
	    }

}
