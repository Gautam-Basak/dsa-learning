package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public static void main(String[] args) {

		// For any particular value we will use either of the two formula
		// Suppose we need to find the nTh row and cTh element then we will use n-1Cc-1
		// i.e (n-1)!/(c-1)! * ((n-1)-(c-1))!
		// Or ans*(row-column)/column;

		// Optimal Solution to Generate Pascal Triangle
		int n = 5;
		List<List<Integer>> finalAns = pascalTriangle(n);

		for (List<Integer> it : finalAns) {
			for (int element : it) {
				System.out.print(element);
			}

			System.out.println();
		}
	}

	private static List<List<Integer>> pascalTriangle(int n) {

		List<List<Integer>> ans = new ArrayList<>();

		for (int row = 1; row <= n; row++) {
			ans.add(generateRow(row));
		}
		return ans;
	}

	private static List<Integer> generateRow(int row) {

		int num = 1;
		List<Integer> ansRow = new ArrayList<>();
		ansRow.add(1);

		for (int col = 1; col < row; col++) {

			num = num * (row - col);
			num = num / col;
			ansRow.add(num);
		}
		return ansRow;
	}

}
