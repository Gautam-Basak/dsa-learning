package Arrays.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class RearrangingArrayWithAlternativePositiveAndNegative {

	public static void main(String[] args) {

		int n = 4;
		int A[] = { 1, 2, -4, -5, -6, -7 };

		/**
		 * Brute Force (Here both positive and negative element are equal)
		 * int[]ans= RearrangebySignBrute(A,n);
		 * System.out.println(Arrays.toString(ans));
		 **/

		/**
		Optimal Solution (Here both positive and negative element are equal)
		ArrayList<Integer> A1 = new ArrayList<>(Arrays.asList(1, 2, -4, -5));
        ArrayList<Integer> ans = RearrangebySignOptimal(A1);
		**/
		
		//Optimal Solution (Here both positive and negative element are not equal)
		int[]ans= RearrangebySignOptimalVarietyTwo(A,n);
		System.out.println(Arrays.toString(ans));
		
	}

	private static int[] RearrangebySignBrute(int[] a, int n) {

		ArrayList<Integer> posList = new ArrayList<>();
		ArrayList<Integer> negList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				posList.add(a[i]);
			} else
				negList.add(a[i]);
		}

		for (int i = 0; i < n / 2; i++) {
			a[2 * i] = posList.get(i);
			a[2 * i + 1] = negList.get(i);
		}

		return a;
	}

	public static ArrayList<Integer> RearrangebySignOptimal(ArrayList<Integer> A) {
        int n = A.size();

        // Define array for storing the ans separately.
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        // positive elements start from 0 and negative from 1.
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {

            // Fill negative elements in odd indices and inc by 2.
            if (A.get(i) < 0) {
                ans.set(negIndex, A.get(i));
                negIndex += 2;
            }

            // Fill positive elements in even indices and inc by 2.
            else {
                ans.set(posIndex, A.get(i));
                posIndex += 2;
            }
        }

        return ans;
    }
	
	private static int[] RearrangebySignOptimalVarietyTwo(int[] a, int n) {
		
		ArrayList<Integer> posList = new ArrayList<>();
		ArrayList<Integer> negList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			if (a[i] > 0) {
				posList.add(a[i]);
			} else
				negList.add(a[i]);
		}
		
		if(posList.size()>negList.size()) {
			
			// First, fill array alternatively till the point 
            // where positives and negatives are equal in number.
			for(int i=0; i<negList.size(); i++) {
				a[2*i] = posList.get(i);
				a[2*i + 1] = negList.get(i);
			}
			// Fill the remaining positives at the end of the array.
			int index = negList.size()*2;
			for(int i=negList.size(); i<posList.size(); i++) {
				a[index] = posList.get(i);
				index++;
			}
		}else
			for(int i=0; i<posList.size(); i++) {
				a[2*i] = posList.get(i);
				a[2*i + 1] = negList.get(i);
			}
			// Fill the remaining positives at the end of the array.
			int index = posList.size()*2;
			for(int i=posList.size(); i<negList.size(); i++) {
				a[index] = negList.get(i);
				index++;
			}
			
		return a;
	}

}
