package String.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortCharacterByFrequency {

	public static void main(String[] args) {

		String s = "aaaaabbcdddd";

		sortCharactersBasedOnFrequency(s, s.length());

	}

	private static void sortCharactersBasedOnFrequency(String s, int n) {

		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < n; i++) {

			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}

		List<Map.Entry<Character, Integer>> listMap = new ArrayList<>(map.entrySet());

		Collections.sort(listMap, new Comparator<Map.Entry<Character, Integer>>() {

			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {

				return o1.getValue() == o2.getValue() ? o1.getKey() - o2.getKey() : o1.getValue() - o2.getValue();
			}
		});
		
		for(Map.Entry<Character, Integer> list : listMap) {
			System.out.println(list.getKey() + " : " + list.getValue());
		}
	}

}
