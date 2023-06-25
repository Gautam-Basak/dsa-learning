package BitManipulation;

public class FindTwoOddOccuringNumbers {

	public static void main(String[] args) {

		int a[] = { 2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2, 6 };

		findTwoOddOccuring(a);

	}

	private static void findTwoOddOccuring(int[] a) {

		int xr = 0;
		for (int i = 0; i < a.length; i++) {

			xr = xr + a[i];
		}

		int number = xr & ~(xr - 1);
		int res1 = 0, res2 = 0;
		for (int i = 0; i < a.length; i++) {
			if ((number & a[i]) != 0)
				res1 = res1 ^ a[i];
			else
				res2 = res2 ^ a[i];
		}
		System.out.println(res1 + " : " + res2);
	}

}
