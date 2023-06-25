package String.Medium;

public class BeautyOfAllSubStrings {

	private static int beautyOfSubStrings(String s, int n) {

		int res = 0;

		for (int i = 0; i < n; i++) {

			int count[] = new int[26];

			for (int j = i; j < n; j++) {

				count[s.charAt(j) - 'a']++;

				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;

				for (int k = 0; k < 26; k++) {

					max = Math.max(max, count[k]);
					if (count[k] != 0) {
						min = Math.min(min, count[k]);
					}
				}

				res += max - min;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		// Beauty of String means Difference in Highest Frequency and Lowest Frequency.

		// Solution with T.C = O(N^2)
		String s = "baa";
		System.out.println(beautyOfSubStrings(s, s.length()));

		// Sliding Window, T.C = O(n)
		
		//Not Working, need to think on this.
		
		System.out.println(beautyOfSubStringsOptimalSol(s, s.length()));

	}

	private static int beautyOfSubStringsOptimalSol(String s, int n) {

		int ans = 0;
		int disCount = 0;
		int left = 0;

		int freq[] = new int[26];

		for (int i = 0; i < n; i++) {

			if (freq[s.charAt(i)- 'a']  == 0) {
				disCount++;
			}
			freq[s.charAt(i) - 'a']++;

			while (disCount > 1) {
				
				int max = 0;
				int min = Integer.MAX_VALUE;

				for (int k = left; k <= i; k++) {

					max = Math.max(max, freq[s.charAt(k)- 'a']);
					min = Math.min(min, freq[s.charAt(k)- 'a']);
				}

				ans = ans + (max - min);

				freq[s.charAt(left)-'a']--;
				if (freq[s.charAt(left)-'a'] == 0) {
					disCount--;
				}
				left++;
			}
			
		}

		return ans;
	}

}
