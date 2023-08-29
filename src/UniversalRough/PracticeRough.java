package UniversalRough;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeRough {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
		System.out.println(list);
		manipulate(list);
		System.out.println(list);
	}

	private static void manipulate(List<Integer> list) {

		list.add(5);
		
	}

}
