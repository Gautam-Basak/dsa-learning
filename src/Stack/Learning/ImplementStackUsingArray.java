package Stack.Learning;

class stack {

	// Here also we should check the size of current stack before pushing, if the
	// current size is greater than the array size then it will through an error

	// Here the size can be found by doing top+1

	private int size = 50;
	private int arr[] = new int[size];
	private int peek = -1;

	void push(int x) {
		peek++;
		arr[peek] = x;
	}

	int peek() {

		return arr[peek];
	}

	int pop() {

		int x = arr[peek];
		peek--;
		return x;
	}

	int size() {

		return peek + 1;
	}

	String isEmpty() {

		if (peek == -1)
			return "Yes";
		else
			return "No";
	}

}

public class ImplementStackUsingArray {

	public static void main(String[] args) {

		stack s = new stack();

		s.push(3);
		s.push(4);
		s.push(5);

		System.out.println("Top of Stack : " + s.peek());
		System.out.println("Size of Stack : " + s.size());
		System.out.println("Pop the Element : " + s.pop());
		System.out.println("Top of Stack : " + s.peek());
		System.out.println("Size of Stack : " + s.size());
		System.out.println("Stack is Empty? : " + s.isEmpty());
	}

}
