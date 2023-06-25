package UniversalRough;

public class UniversalRough {
	
	//Leftmost Character Occurrence
	public static void main(String[] args) {

		String s = "bbcadecfa";
		int a = 0, b = 0;
		for (int i = 0; i < s.length(); i++) {

			a = s.indexOf(s.charAt(i), i + 1);

			if (a > i) {
				b = i;
				break;
			}

		}
		if (a > 0)
			System.out.println(b + " : " + s.charAt(b));
		else
			System.out.println("No such Character Found");
	}
}