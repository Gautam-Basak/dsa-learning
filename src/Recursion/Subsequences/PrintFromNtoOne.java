package Recursion.Subsequences;

public class PrintFromNtoOne {

	public static void main(String[] args) {

		int n = 4;

		print(n, n);

		printWithOneVariable(n);
		
		printWithTwoVariableUsingBackTracking(1,n);

	}

	private static void print(int i, int n) {

		if (i < 1) {
			return;
		}
		System.out.println(i);
		print(i - 1, n);

	}

	private static void printWithOneVariable(int n) {

		while (n == 0) {
			return;
		}
		System.out.println(n);
		printWithOneVariable(n - 1);

	}
	
	public static void printWithTwoVariableUsingBackTracking(int i, int n) {

		if (i > n) {
			return;
		}
		printWithTwoVariableUsingBackTracking(i + 1, n);
		System.out.println(i);
	}

}
