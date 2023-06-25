package Arrays.Easy;

public class CountMaximumConsecutiveOnes {

	public static void main(String[] args) {

		int a[] = { 1, 1, 2, 3, 4, 1, 1, 1, 1, 1, 6, 7, 8 };

		System.out.println(maximumConsecutiveOnes(a));

	}

	private static int maximumConsecutiveOnes(int[] a) {

		int count = 0;
		int maxConsecutive = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] == 1)
				count++;
			else
				count = 0;

			maxConsecutive = Math.max(maxConsecutive, count);
		}
		return maxConsecutive;

	}

}
