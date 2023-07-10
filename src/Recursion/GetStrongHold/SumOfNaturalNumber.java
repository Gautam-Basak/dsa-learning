package Recursion.GetStrongHold;

public class SumOfNaturalNumber {

	public static void main(String[] args) {

		int i = 3;

		System.out.println(functionalRecursion(i));

		usingParameterAndRecursion(i, i);

	}

	private static int functionalRecursion(int i) {
		if (i <= 1)
			return 1;
		return i + functionalRecursion(i - 1);

	}

	private static void usingParameterAndRecursion(int i, int sum) {

		if (i == 0) {
			System.out.println(sum);
			return;
		}
		usingParameterAndRecursion(i - 1, sum + 1);
	}

}
