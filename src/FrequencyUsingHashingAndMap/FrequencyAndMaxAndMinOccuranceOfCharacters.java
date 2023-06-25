package FrequencyUsingHashingAndMap;

import java.util.HashMap;
import java.util.Map;

public class FrequencyAndMaxAndMinOccuranceOfCharacters {

	static final int ASCII_SIZE = 256;

	static char getMaxOccurringChar(String str) {

		int count[] = new int[ASCII_SIZE];

		int len = str.length();
		for (int i = 0; i < len; i++)
			count[str.charAt(i)]++;

		int max = -1;
		int min = 256;
		char result = ' ';

		for (int i = 0; i < len; i++) {
			if (min > count[str.charAt(i)]) {
				min = count[str.charAt(i)];
				result = str.charAt(i);
			}
			
		}
		System.out.println(min);
		return result;
	}

	public static void main(String[] args) {
		String str = "aabbc";
		System.out.println("Max occurring character is " + getMaxOccurringChar(str));
	}
}
