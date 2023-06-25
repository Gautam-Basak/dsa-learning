package BinarySearch.OneDArrays;

public class FindMountainElement {

	public static void main(String[] args) {

		// Here as there is no target everything will be searched w.r.t "mid" or "mid
		// element"

		int a[] = { 2, 5, 3 };

		System.out.println(findMountain(a, a.length));
	}

	private static int findMountain(int[] a, int n) {

		int start = 0;
		int end = n - 1;

		// Here we are not putting equal sign because here to find the ans we are trying
		// to make start, middle and end to be equal, so when all three are equal and if
		// condition is also having equal sign, it will not come out of the loop.
		// So, to break the loop and come out of it, we remove the equal sign.
		while (start < end) {
			int mid = start + (end - start) / 2;

			if (a[mid] > a[mid + 1]) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		return start; // or end, anything you can return, because when to loop breaks mid, start and
						// end all are pointing to same.

	}
}
