package Queue.Implementation;

import java.util.LinkedList;
import java.util.Queue;

public class GenerateNumberWithGivenQueue {

	public static void main(String[] args) {

		// Given a number "n", print first "n" number(in increasing number) such that
		// all these numbers have digits in set {5, 6}
		// O/P - {5, 6, 55, 56, 65, 66, 555, 556, 565, 566}

		int n = 10;
		printFirstN(n);

	}

	private static void printFirstN(int n) {

		Queue<String> q = new LinkedList<>();

		// The numbers are considered String because if we continue with Integer that
		// might become very large.
		//For an instance, if you check above example for first 10 number it goes up to 566.
		q.offer("5");
		q.offer("6");
		
		
		for(int i=0; i<n; i++) {
			
			String curr = q.poll();
			
			System.out.print(curr + " ");
			
			q.add(curr + "5");
			q.add(curr + "6");
			
		}

	}

}
