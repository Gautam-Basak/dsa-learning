package BinarySearch.OneDArrays;

public class CountOccuranceOfElementInSortedArrayWithDuplicates {

	//Search For Element
	private static int binarySearch(int[] a, int k, int n) {

		int start = 0, end = n - 1;

		while (start <= end) {
			int mid = (start + end) >> 1;

			if (a[mid] == k) {
				return mid;

			} else if (a[mid] < k) {
				start = mid + 1;
				
			} else {
				end = mid - 1;
				
			}
		}
		return -1;
	}

	public static int findOccuranceOfGivenElement(int[] a, int k, int n) {
		
		//If found we will check both left and right side Else return 0;
		int elementIndex = binarySearch(a, k, n);

		if (elementIndex == -1)
			return 0;

		int count = 1;
		
		//Search in Left Side after "K" is found
		int left = elementIndex - 1;
		while (left >= 0 && a[left] == k) {
			count++;
			left--;
		}
		
		//Search in Right Side after "K" is found
		int right = elementIndex + 1;
		while (right < n && a[right] == k) {
			count++;
			right++;
		}

		return count;
	}

	public static void main(String[] args) {

		int a[] = { 2, 2, 2, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 7, 7 };
		int k = 7;

		// Steps.
		// 1) Using Binary Search we will find whether "K" is present or not in the
		// array
		// 2) If present we will search for further in both the end.
		System.out.println(findOccuranceOfGivenElement(a, k, a.length));
	}

}
