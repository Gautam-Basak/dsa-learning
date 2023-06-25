package Recursion.Subsequences;

public class PrintFromOneToN {

	public static void main(String[] args) {

		int n = 5;

		printWithOneVariableUsingBackTracking(n);

		 

	}

	public static void printWithOneVariableUsingBackTracking(int n) {

		if (n == 0) {

			return;
		}
		printWithOneVariableUsingBackTracking(n - 1);
		System.out.println(n);
	}

	

}
