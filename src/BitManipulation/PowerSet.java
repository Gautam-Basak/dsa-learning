package BitManipulation;

public class PowerSet {

	public static void main(String[] args) {

		// Power Set means all possible sub set of the given string or array etc
		// Formula for possible sub set is 2 power n (where n is the size of array or
		// string) and this include empty string or empty array
		String s = "abc";

		findPowerSet(s, s.length());

	}

	private static void findPowerSet(String s, int length) {

		int powerSetSize = (int) Math.pow(2, length);

		for (int i = 0; i < powerSetSize; i++) {

			for (int j = 0; j < s.length(); j++) {

				if ((i & (1 << j)) > 0)
					System.out.print(s.charAt(j));
			}
			System.out.println();
		}
	}

}
