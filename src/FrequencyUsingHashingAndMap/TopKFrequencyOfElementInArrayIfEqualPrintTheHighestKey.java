package FrequencyUsingHashingAndMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TopKFrequencyOfElementInArrayIfEqualPrintTheHighestKey {

	private static int[] topKFrequency(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (Integer i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

		list.sort((a, b) -> Objects.equals(a.getValue(), b.getValue()) ? b.getKey() - a.getKey()
				: b.getValue() - a.getValue());

		int[] ans = new int[k];
		for (int i = 0; i < k; i++) {
			ans[i] = list.get(i).getKey();
		}

		return ans;
	}

	public static void main(String[] args) {
		int nums[] = { 2, 2, 2, 3, 3, 3, 3,  4, 4 };
		int k = 2;
		int ans[] = topKFrequency(nums, k);

		System.out.println(Arrays.toString(ans));

	}

}
