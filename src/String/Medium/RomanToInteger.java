package String.Medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {

		String str = "IX";
		System.out.println("Integer form of Roman Numeral is " + romanToDecimal(str, str.length()));

	}

	private static int romanToDecimal(String str, int n) {

		final Map<Character, Integer> roman = new HashMap<>();
		roman.put('I', 1);
		roman.put('V', 5);
		roman.put('X', 10);
		roman.put('L', 50);
		roman.put('C', 100);
		roman.put('D', 500);
		roman.put('M', 1000);
		
		int result =0;

		for (int i = 0; i < n; i++) {

			if (i != n - 1 && roman.get(str.charAt(i)) < roman.get(str.charAt(i + 1))) {
				result = result + roman.get(str.charAt(i + 1))-roman.get(str.charAt(i));
				i++;
			}else {
				result = result + roman.get(str.charAt(i));
			}

		}
		return result;
	}

}
