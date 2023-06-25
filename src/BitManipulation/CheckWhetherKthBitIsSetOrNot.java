package BitManipulation;

public class CheckWhetherKthBitIsSetOrNot {

	public static void main(String[] args) {
		
		//Using Left Shift
		int n = 5, x = 0;
		  int p = (1 << x);
		  if ((n & p) != 0) {
		    System.out.println("YES");
		  } else {
		    System.out.println("NO");
		  }
		  
		  int m = 5, y = 0;
		  int q = (m >> y);
		  if ((q & 1) != 0) {
		    System.out.println("YES");
		  } else {
		    System.out.println("NO");
		  }

	}

}
