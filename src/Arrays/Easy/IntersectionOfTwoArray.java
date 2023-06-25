package Arrays.Easy;

import java.util.ArrayList;

public class IntersectionOfTwoArray {

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

		/***
		 // 1. Brute Force
		  ArrayList<Integer> ans = findIntersectionBrute(arr1, arr2); for (int i = 0; i
		  for (int i = 0; i < ans.size(); i++)  { 
			  System.out.print(ans.get(i) + " ");
		  }
		***/
		   
		 // 2. Optimal
		ArrayList<Integer> ans = findIntersectionOptimal(arr1, arr2);
		for (int i = 0; i < ans.size(); i++) {
			System.out.print(ans.get(i) + " ");
		}

	}
	
	//Brute Force
	private static ArrayList<Integer> findIntersectionBrute(int[] arr1, int[] arr2) {

		ArrayList<Integer> intersection = new ArrayList<>();

		int visited[] = new int[arr2.length];

		for (int i = 0; i < arr1.length; i++) {

			for (int j = 0; j < arr2.length; j++) {

				if (arr1[i] == arr2[j] && visited[j] == 0) {
					intersection.add(arr2[j]);
					visited[j] = 1;
					break;
				} else if (arr1[i] < arr2[j])
					break;
			}
		}
		return intersection;

	}
	
	//Optimal
	private static ArrayList<Integer> findIntersectionOptimal(int[] arr1, int[] arr2) {

		ArrayList<Integer> intersection = new ArrayList<>();
		int i = 0, j = 0;

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] < arr2[j]) {
				i++;
			} else if (arr1[i] > arr2[j]) {
				j++;
			} else {
				intersection.add(arr1[i]);
				i++;
				j++;
			}
		}
		return intersection;
	}

}
