package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class NumberThatAppearsOnce {

	public static void main(String[] args) {

		int a[] = { 2, 1, 4, 2, 1 };

		// Brute Force
		// System.out.println(numberThatAppearsOnceBruteForce(a));

		// Better Solution (We can get Better Solution by using Hashing or Map)
		// System.out.println(numberThatAppearsOnceBetterSolution(a));

		// Optimal Solution using XOR
		System.out.println(numberThatAppearsOnceOptimalSolution(a));

	}

	// Brute Force
	private static int numberThatAppearsOnceBruteForce(int[] a) {

		for (int i = 0; i < a.length; i++) {

			int count = 0;
			int num = a[i];

			for (int j = 0; j < a.length; j++) {

				if (num == a[j])
					count++;
			}
			if (count == 1) {
				return num;

			}
		}
		return -1;

	}

	// Better Solution Using Map
	private static Integer numberThatAppearsOnceBetterSolution(int[] a) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < a.length; i++) {

			map.put(a[i], map.getOrDefault(a[i], 0) + 1);
		}

		for (Map.Entry<Integer, Integer> map1 : map.entrySet()) {
			if (map1.getValue() == 1) {
				return map1.getKey();
			}
		}

		return -1;
	}
	
	
	private static int numberThatAppearsOnceOptimalSolution(int[] a) {
		
		int XOR = 0;
		for(int i=0; i<a.length; i++) {
			XOR = XOR ^ a[i];
		}
		return XOR;
	}

}
