package BitManipulation;

public class CheckWhetherGivenNumberIsPowerOfTwoOrNot {

	public static void main(String[] args) {

		int n = 4;

		System.out.println(checkPowerOfTwo(n));

		// Using Brian Karnigam's Algorithm
		System.out.println(checkPowerOfTwoOptimal(n));

	}

	private static boolean checkPowerOfTwoOptimal(int n) {
		if (n == 0)
			return false;

		// Every number which is a power of 2, has only one bit set.
		// And if we do n & (n-1), it will remove the last set bit and if it gives zero
		// that means it has only on bit set which indirectly means its a power of two.
		return ((n & (n - 1)) == 0);
	}

	private static boolean checkPowerOfTwo(int n) {

		if (n == 0)
			return false;

		while (n > 1) {
			if (n % 2 != 0)
				return false;
			n = n / 2;
		}
		return true;
	}

}
