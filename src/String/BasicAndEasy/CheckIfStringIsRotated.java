package String.BasicAndEasy;

public class CheckIfStringIsRotated {

	public static void main(String[] args) {

		String s1 = "abc";
		String s2 = "cba";

		System.out.println(checkRotation(s1, s2));

	}

	private static boolean checkRotation(String s1, String s2) {

		if (s1.length() != s2.length())
			return false;
		return (s1 + s1).indexOf(s2) != -1;

	}

}
