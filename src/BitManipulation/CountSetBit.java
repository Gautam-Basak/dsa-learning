package BitManipulation;

public class CountSetBit {

	// Method One
	// Checking for Odd, increase the count if odd, divided the number.
	static void findCountMethodOne(int n) {

		int count = 0;
		while (n > 0) {
			// Odd number always have last bit set, we check either odd or even, if odd
			// increase the count
			if (n % 2 != 0)
				count++;
			// Divided any number by two, "remove the last bit"(either odd or even) or
			// dividing odd number by 2
			// gives you result an even number and dividing even number by 2 gives you
			// result an odd number
			n = n / 2;
		}
		System.out.println(count);
	}

	static void findCountMethodTwo(int n) {

		int count = 0;
		while (n > 0) {

			// "And" Operation with any Odd number with 1, will always give 1,
			// Then Increase the count.
			if ((n & 1) != 0)
				count++;
			// Divide the number by two, will remove the last bit.
			n = n >> 1;
		}
		System.out.println(count);
	}

	static void findCountMethodThree(int n) {

		int count = 0;
		while (n > 0) {
			// If you do "AND" number and one lesser than number (ex - 40 & 39), it will
			// remove the rightmost set bit.
			// Therefore, the Time Complexity will be the number set bit.
			n = (n & (n - 1));
			count++;
		}
		System.out.println(count);
	}

	public static void main(String[] args) {

		int n = 5;

		// T.C = Binary Representation of number "n" i.e if n is represented in 32 bits
		// then O(32) and if 64 then O(64)
		findCountMethodOne(n);

		// Using BitWise Operator
		// T.C = Same as findCountMethodOne(n);
		findCountMethodTwo(n);

		// Brian Kernigam's Algorithm
		// T.C = O(Total number of set bit available in "n")
		findCountMethodThree(n);

	}

}
