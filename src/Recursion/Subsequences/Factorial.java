package Recursion.Subsequences;

public class Factorial {

	public static void main(String[] args) {
		int n = 5;

		parameterisedWay(n, 1);

		System.out.println(functionalWay(n));

	}

	public static void parameterisedWay(int n, int multi) {

		if (n == 0 || n == 1) {
			System.out.println(multi);
			return;
		}
		parameterisedWay(n - 1, multi * n);

	}

	private static int functionalWay(int n) {

		return (n == 1 || n == 0) ? 1 : n * functionalWay(n - 1);

	}
}
