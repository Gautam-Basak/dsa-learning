package Arrays.Medium;

import java.util.ArrayList;

public class LearderInArray {

	public static void main(String[] args) {

		int a[] = { 5, 4, 3, 2, 1 };

		// 1. Brute Force
		// ArrayList<Integer> list = findLeadersBrute(a, a.length);
		// System.out.println(list);

		// 2. Optimal Solution
		// Last element will always leader. W.R.T that we will move towards left and
		// check for leader
		// and if on the right if the elements are smaller we will we will change and
		// collect the leaders.
		ArrayList<Integer> list = findLeadersOptimal(a, a.length);
		System.out.println(list);
	}

	public static ArrayList<Integer> findLeadersBrute(int a[], int n) {

		ArrayList<Integer> list = new ArrayList<>();

		boolean leader = true;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[j] > a[i]) {
					leader = false;
					break;
				}
			}
			if (leader)
				list.add(a[i]);
		}

		return list;
	}

	public static ArrayList<Integer> findLeadersOptimal(int a[], int n) {

		ArrayList<Integer> list = new ArrayList<>();

		int leader = a[n - 1];

		list.add(leader);

		for (int i = n - 2; i >= 0; i--) {
			if (a[i] > leader) {
				list.add(a[i]);
				leader = a[i];
			}
		}
		return list;

	}
}
