package String.Medium;

public class MaximumDepthOfParanthesis {

	private static int depthOfParanthesis(String s, int n) {

		int currentCount = 0;
		int maxCount = 0;

		for (int i = 0; i < n; i++) {

			if (s.charAt(i) == '(') {
				currentCount++;
				maxCount = Math.max(maxCount, currentCount);
			} else if (s.charAt(i) == ')') {
				if (currentCount > 0) {
					currentCount--;

				} else
					return -1;
			}
		}
		return currentCount > 0 ? -1 : maxCount;

	}

	public static void main(String[] args) {

		String s = "( p((q)) ((s)t) )";
		System.out.println(depthOfParanthesis(s, s.length()));

	}

}
