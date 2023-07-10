package Recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	private static List<List<String>> solveNQueens(int n) {

		char board[][] = new char[n][n];
		int leftRow[] = new int[n];
		int upperDiagonal[] = new int[2 * n - 1];
		int lowerDiagonal[] = new int[2 * n - 1];
		List<List<String>> res = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}

		solve(0, board, res, leftRow, upperDiagonal, lowerDiagonal);

		return res;
	}

	private static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] upperDiagonal,
			int[] lowerDiagonal) {

		if (col == board.length) {
			res.add(construct(board));
			return;
		}

		for (int row = 0; row < board.length; row++) {

			if (leftRow[row] == 0 && upperDiagonal[board.length - 1 + col - row] == 0
					&& lowerDiagonal[row + col] == 0) {

				board[row][col] = 'Q';

				leftRow[row] = 1;
				upperDiagonal[board.length - 1 + col - row] = 1;
				lowerDiagonal[row + col] = 1;

				solve(col + 1, board, res, leftRow, upperDiagonal, lowerDiagonal);
				
				board[row][col] = '.';
				
				leftRow[row] = 0;
				upperDiagonal[board.length - 1 + col - row] = 0;
				lowerDiagonal[row + col] = 0;
			}
		}

	}

	private static List<String> construct(char[][] board) {

		List<String> res = new ArrayList<>();

		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}

	public static void main(String[] args) {

		int n = 4;
		List<List<String>> queen = solveNQueens(n);
		int i = 1;

		for (List<String> it : queen) {
			System.out.println("Arrangement " + i);
			for (String s : it) {
				System.out.println(s);
			}
			System.out.println();
			i = i + 1;
		}

	}

}
