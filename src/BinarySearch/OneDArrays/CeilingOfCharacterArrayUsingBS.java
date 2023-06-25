package BinarySearch.OneDArrays;

public class CeilingOfCharacterArrayUsingBS {

	public static void main(String[] args) {

		// Conditions :-
		// 1. Here they asked return the ceiling char greater the target char(we need to
		// avoid the equal value)
		// 2. If the char is not present return the 1st char. Suppose the target char is
		// the last char of the
		// array, as in the 1st condition we need to avoid equal condition so we will
		// return 1st char.
		// -- In ceiling problem we use to return the start, but here to fulfil the
		// condition 2 we will return
		// start % a.lenght(there will be no problem as any number % by bigger number
		// will give the number itself, so when the condition fails that i.e start>end,
		// start become end + 1 and that time end + 1 become a.lenght and start %
		// a.lenght will give zero,
		// which will satisfy the 2nd condition.
		
		
		char a[] = { 'a', 'b', 'c', 'd', 'e' };
		char target = 'e';

		System.out.println(ceilingBinarySearch(a, target));

	}

	private static char ceilingBinarySearch(char[] a, char target) {

		int start = 0;
		int end = a.length - 1;

		while (start <= end) {
			
			int mid = start + (end - start) / 2; 

			// What if the target element is greater than greatest element in the array
			//We don't this condition as this will be taken care by condition 2.
			/**
			if (target > a[a.length - 1])
				return -1;
			**/	
			if (target < a[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}	
			/**We don't need this condition, as in question it mentioned avoid equal case	
			} else
				return mid;
			**/	
		}

		return a[start%a.length];
	}

}
