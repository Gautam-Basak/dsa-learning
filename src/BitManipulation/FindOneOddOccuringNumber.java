package BitManipulation;

public class FindOneOddOccuringNumber {

	public static void main(String[] args) {
		
		int a[] = {2, 3, 5, 4, 5, 2, 4, 3, 5, 2, 4, 4, 2};
		
		//Method 1:
		//Use two for loops and one counter, if counter % 2 != 0, return that a[i].
		
		//Method 2: Here T.C = O(n) and S.C = O(n)
		//Use Hashing, check the value w.r.t key, if it is odd return that key.
		
		//Method 3: Here T.C = O(n) and S.C = O(1)
		//Use XOR
		findOneOddOccuring(a);

	}

	private static void findOneOddOccuring(int[] a) {
		
		int res=0;
		for(int i=0; i< a.length; i++) {
			
			res = res ^a[i];
		}
		System.out.println(res);
	}

}
