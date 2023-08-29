package String.BasicAndEasy;

public class FindLongestCommonPrefix {

	public static String longestCommonPrefix(String[] arr) {
		int n = arr.length;

		String result = arr[0];

		for (int i = 1; i < n; i++) {

			while (arr[i].indexOf(result) != 0) {

				System.out.println(arr[i].indexOf(result));

				result = result.substring(0, result.length() - 1);

				if (result.isEmpty()) {
					return "-1";
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

		String[] input = { "gee", "geeksforgeeks", "geeks", "geeks" };
		System.out.println("The longest Common Prefix is : " + longestCommonPrefix(input));

	}

}
