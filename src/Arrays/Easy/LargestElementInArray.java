package Arrays.Easy;

import java.util.Arrays;

public class LargestElementInArray {
	
	private static int findLargestElement(int[] arr) {
		
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max)
				max=arr[i];
		}
		return max;
		
	}

	public static void main(String[] args) {

		int arr[] = { 2, 5, 1, 7, 3, 8 };
		
		//Brute Force
		//TC = O(N*Log(N))
		//SC = O(N)
		Arrays.sort(arr);
		System.out.println(arr[arr.length - 1]);
		
		
		//Optimal Solution
		//TC = O(N)
		//SC = O(1)
		System.out.println(findLargestElement(arr));
		

	}

	

}
