package UniversalRough;

public class Rough2 {

	public static void main(String[] args) {
		int x = 5;
		int y=6;
		int a[] = {1};
		reCall(x, y, a);
		System.out.println(a[0]);
	}

	private static int reCall(int x, int y, int[]a) {
		
		int z = x*y;
		if (z == 10)
			return 0;

		a[0]=z;
		return 0;
	}

}
