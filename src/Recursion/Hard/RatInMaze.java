package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
	private static void solve(int i, int j, int a[][], int n, ArrayList<String> ans, String move, int vis[][], int di[],
			int dj[]) {
		if (i == n - 1 && j == n - 1) {
			ans.add(move);
			return;
		}
		String dir = "DLRU";
		for (int ind = 0; ind < n; ind++) {
			int nexti = i + di[ind];
			int nextj = j + dj[ind];
			if (nexti >= 0 && nextj >= 0 && nexti < n && nextj < n && vis[nexti][nextj] == 0 && a[nexti][nextj] == 1) {

				vis[i][j] = 1;
				solve(nexti, nextj, a, n, ans, move + dir.charAt(ind), vis, di, dj);
				vis[i][j] = 0;

			}
		}
	}

	public static ArrayList<String> findPath(int[][] a, int n) {
		int vis[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				vis[i][j] = 0;
			}
		}
		int di[] = { +1, 0, 0, -1 };
		int dj[] = { 0, -1, 1, 0 };
		ArrayList<String> ans = new ArrayList<>();
		if (a[0][0] == 1)
			solve(0, 0, a, n, ans, "", vis, di, dj);
		return ans;
	}

	public static void main(String[] args) {

		// While be given a n*m matrix, with 0 and 1 random values, follow the one and
		// get to the last index.
		// While traversal, get the directions in Lexicographically order and concat it.
		// Down - D, Up - U, Left - L, Right - R

		int n = 4;
		int[][] a = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

		ArrayList<String> res = findPath(a, n);
		if (res.size() > 0) {
			for (int i = 0; i < res.size(); i++)
				System.out.print(res.get(i) + " ");
			System.out.println();
		} else {
			System.out.println(-1);
		}
	}

}
